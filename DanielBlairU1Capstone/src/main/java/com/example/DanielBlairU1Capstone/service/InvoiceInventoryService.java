package com.example.DanielBlairU1Capstone.service;

import com.example.DanielBlairU1Capstone.dao.*;
import com.example.DanielBlairU1Capstone.exception.NotFoundException;
import com.example.DanielBlairU1Capstone.model.*;
import com.example.DanielBlairU1Capstone.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceInventoryService {

    private BigDecimal min = new BigDecimal("0");
    private BigDecimal max = new BigDecimal("999.99");
    GameDao gameDao;
    ConsoleDao consoleDao;
    TshirtDao tshirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceDao invoiceDao;

    @Autowired
    public InvoiceInventoryService(GameDao gameDao, ConsoleDao consoleDao, TshirtDao tshirtDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, InvoiceDao invoiceDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tshirtDao = tshirtDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.invoiceDao = invoiceDao;
    }

    @Transactional
    public GameViewModel saveGame(GameViewModel gvm) {
        Game game = new Game();
        game.setTitle(gvm.getTitle());
        game.setEsrb_rating(gvm.getEsrb_rating());
        game.setDescription(gvm.getDescription());
        game.setPrice(gvm.getPrice());
        game.setStudio(gvm.getStudio());
        game.setQuantity(gvm.getQuantity());

        gvm.setId(gameDao.add(game).getId());

        return gvm;
    }

    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel cvm) {
        Console console = new Console();
        console.setModel(cvm.getModel());
        console.setManufacturer(cvm.getManufacturer());
        console.setMemory_amt(cvm.getMemory_amount());
        console.setProcessor(cvm.getProcessor());
        console.setPrice(cvm.getPrice());
        console.setQuantity(cvm.getQuantity());

        cvm.setId(consoleDao.add(console).getId());

        return cvm;
    }

    @Transactional
    public TshirtViewModel saveTshirt(TshirtViewModel tvm) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tvm.getSize());
        tshirt.setColor(tvm.getColor());
        tshirt.setDescription(tvm.getDescription());
        tshirt.setPrice(tvm.getPrice());
        tshirt.setQuantity(tvm.getQuantity());

        tvm.setId(tshirtDao.add(tshirt).getId());

        return tvm;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(PurchaseViewModel pvm) {
        Invoice invoice = new Invoice();
        validateItemType(pvm);
        validateAndSetZip(pvm, invoice);
        SalesTaxRate str = validateStateAndGetTax(pvm);
        ProcessingFee pf = validateQtyAndCalculateFee(pvm);

        Item item = new Item();
        if (pvm.getItem_type().equals("console"))
            consoleInvoiceHelper(pvm, item);
        if (pvm.getItem_type().equals("game"))
            gameInvoiceHelper(pvm, item);
        if (pvm.getItem_type().equals("t-shirt"))
            tShirtInvoiceHelper(pvm, item);

        invoice.setPrice(item.getPrice());
        invoice.setSubtotal(item.getPrice()
                .multiply(pvm.getQuantity())
                .setScale(2, BigDecimal.ROUND_HALF_UP));

        return calculateTotalAndBuildIvm(pvm, invoice, pf, str);
    }

    private Invoice validateAndSetZip(PurchaseViewModel pvm, Invoice invoice) {
        if (!(Integer.parseInt(pvm.getZipcode()) > 0))
            throw new IllegalArgumentException("zipcode must be 5 numbers");
        invoice.setZipcode(pvm.getZipcode());
        return invoice;
    }

    private void validateItemType(PurchaseViewModel pvm) {
        pvm.setItem_type(pvm.getItem_type().toLowerCase());

        if (!(pvm.getItem_type().equals("console")) &&
                !(pvm.getItem_type().equals("t-shirt")) &&
                !(pvm.getItem_type().equals("game")))
            throw new IllegalArgumentException("Item type must be console, t-shirt, or game");
    }

    private InvoiceViewModel calculateTotalAndBuildIvm(PurchaseViewModel pvm, Invoice invoice, ProcessingFee pf, SalesTaxRate str) {
        invoice.setProcessing_fee(pf.getFee());
        invoice.setTax(invoice.getSubtotal()
                .multiply(str.getRate())
                .setScale(2, BigDecimal.ROUND_HALF_UP));

        if (invoice.getSubtotal()
                .add(invoice.getTax())
                .add(invoice.getProcessing_fee()).compareTo(max) > 0)
            throw new IllegalArgumentException("Your total has exceeded the limit of $" + max);

        invoice.setTotal(invoice.getSubtotal()
                .add(invoice.getTax())
                .add(invoice.getProcessing_fee()));
        invoice.setName(pvm.getName());
        invoice.setStreet(pvm.getStreet());
        invoice.setCity(pvm.getCity());
        invoice.setState(pvm.getState());
        invoice.setItem_type(pvm.getItem_type());
        invoice.setQuantity(pvm.getQuantity());
        invoice.setItem_id(pvm.getItem_id());
        invoice = invoiceDao.add(invoice);

        return buildInvoiceViewModel(invoice);
    }

    private ProcessingFee validateQtyAndCalculateFee(PurchaseViewModel pvm) {
        pvm.setQuantity(pvm.getQuantity()
                .setScale(0, BigDecimal.ROUND_FLOOR));
        if (pvm.getQuantity()
                .compareTo(new BigDecimal("0")) <= 0)
            throw new IllegalArgumentException("You must enter a quantity greater than or equal to 1");

        ProcessingFee pf = processingFeeDao.get(pvm.getItem_type());
        if (pvm.getQuantity()
                .compareTo(new BigDecimal("10")) > 0)
            pf.setFee(pf.getFee()
                    .add(new BigDecimal("15.49")));

        return pf;
    }

    private SalesTaxRate validateStateAndGetTax(PurchaseViewModel pvm) {
        pvm.setState(pvm.getState().toUpperCase());

        if (salesTaxRateDao.get(pvm.getState()) == null)
            throw new IllegalArgumentException("Enter a valid 2-character statecode");

        return salesTaxRateDao.get(pvm.getState());
    }

    private Item consoleInvoiceHelper(PurchaseViewModel pvm, Item item) {
        Console console = consoleDao.get(pvm.getItem_id());

        if (console == null)
            throw new NotFoundException("No console found @ ID " + pvm.getItem_id());
        if (pvm.getQuantity().compareTo(console.getQuantity()) > 0)
            throw new IllegalArgumentException("Please select a lower quantity.");
        if (console.getPrice()
                .multiply(pvm.getQuantity())
                .setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(max) > 0)
            throw new IllegalArgumentException("Your subtotal has exceeded the limit of $" + max);

        item.setPrice(console.getPrice());
        console.setQuantity(console.getQuantity()
                .subtract(pvm.getQuantity()));

        consoleDao.update(console);
        return item;
    }

    private Item gameInvoiceHelper(PurchaseViewModel pvm, Item item) {
        Game game = gameDao.get(pvm.getItem_id());

        if (game == null)
            throw new NotFoundException("No game found @ ID " + pvm.getItem_id());
        if (pvm.getQuantity().compareTo(game.getQuantity()) > 0)
            throw new IllegalArgumentException("Please select a lower quantity.");
        if (game.getPrice()
                .multiply(pvm.getQuantity())
                .setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(max) > 0)
            throw new IllegalArgumentException("Your subtotal has exceeded the limit of $" + max);

        item.setPrice(game.getPrice());
        game.setQuantity(game.getQuantity()
                .subtract(pvm.getQuantity()));

        gameDao.update(game);
        return item;
    }

    private Item tShirtInvoiceHelper(PurchaseViewModel pvm, Item item) {
        Tshirt tshirt = tshirtDao.get(pvm.getItem_id());

        if (tshirt == null)
            throw new NotFoundException("No tshirt found @ ID " + pvm.getItem_id());
        if (pvm.getQuantity().compareTo(tshirt.getQuantity()) > 0)
            throw new IllegalArgumentException("Please select a lower quantity.");
        if (tshirt.getPrice()
                .multiply(pvm.getQuantity())
                .setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(max) > 0)
            throw new IllegalArgumentException("Your subtotal has exceeded the limit of $" + max);

        item.setPrice(tshirt.getPrice());
        tshirt.setQuantity(tshirt.getQuantity()
                .subtract(pvm.getQuantity()));

        tshirtDao.update(tshirt);
        return item;
    }

    public GameViewModel findGameById(int id) {
        Game game = gameDao.get(id);
        if (game == null)
            throw new NotFoundException("No game exists @ ID " + id);
        return buildGameViewModel(game);
    }

    public List<GameViewModel> findGamesByStudio(String studio) {
        List<GameViewModel> gvmList = new ArrayList<>();
        gameDao.getByStudio(studio).stream().forEach(game -> gvmList.add(buildGameViewModel(game)));

        return gvmList;
    }

    public List<GameViewModel> findAllGames() {
        List<GameViewModel> gvmList = new ArrayList<>();
        gameDao.getAll().stream().forEach(game -> gvmList.add(buildGameViewModel(game)));

        return gvmList;
    }

    public List<GameViewModel> findGamesByESRBRating(String esrbRating) {
        List<GameViewModel> gvmList = new ArrayList<>();
        gameDao.getByEsrb(esrbRating).stream().forEach(game -> gvmList.add(buildGameViewModel(game)));

        return gvmList;
    }

    public List<GameViewModel> findGamesByTitle(String title) {
        List<GameViewModel> gvmList = new ArrayList<>();
        gameDao.getByTitle(title).stream().forEach(game -> gvmList.add(buildGameViewModel(game)));

        return gvmList;
    }

    public ConsoleViewModel findConsoleById(int id) {
        Console console = consoleDao.get(id);
        if (console == null)
            throw new NotFoundException("No console exists @ ID " + id);
        return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        consoleDao.getAll().stream().forEach(console -> cvmList.add(buildConsoleViewModel(console)));

        return cvmList;
    }

    public List<ConsoleViewModel> findConsolesByManufacturer(String manufacturer) {
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        consoleDao.getByManufacturer(manufacturer).stream().forEach(console -> cvmList.add(buildConsoleViewModel(console)));

        return cvmList;
    }

    public TshirtViewModel findTshirtById(int id) {
        Tshirt tshirt = tshirtDao.get(id);
        if (tshirt == null)
            throw new NotFoundException("No t-shirt exists @ ID " + id);
        return buildTshirtViewModel(tshirt);
    }

    public List<TshirtViewModel> findAllTshirts() {
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tshirtDao.getAll().stream().forEach(tshirt -> tvmList.add(buildTshirtViewModel(tshirt)));

        return tvmList;
    }

    public List<TshirtViewModel> findTshirtsByColor(String color) {
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tshirtDao.getByColor(color).stream().forEach(tshirt -> tvmList.add(buildTshirtViewModel(tshirt)));

        return tvmList;
    }

    public List<TshirtViewModel> findTshirtsBySize(String size) {
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tshirtDao.getBySize(size).stream().forEach(tshirt -> tvmList.add(buildTshirtViewModel(tshirt)));

        return tvmList;
    }

    public InvoiceViewModel findInvoiceById(int id) {
        Invoice invoice = invoiceDao.get(id);
        if (invoice == null)
            throw new NotFoundException("No invoice exists @ ID " + id);
        return buildInvoiceViewModel(invoice);
    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<InvoiceViewModel> ivmList = new ArrayList<>();
        invoiceDao.getAll().stream().forEach(invoice -> ivmList.add(buildInvoiceViewModel(invoice)));

        return ivmList;
    }

    @Transactional
    public void removeGame(int id) {
        if (gameDao.get(id) == null)
            throw new NotFoundException("No game found @ ID " + id);
        gameDao.delete(id);
    }

    @Transactional
    public void removeConsole(int id) {
        if (consoleDao.get(id) == null)
            throw new NotFoundException("No console found @ ID " + id);
        consoleDao.delete(id);
    }

    @Transactional
    public void removeTshirt(int id) {
        if (tshirtDao.get(id) == null)
            throw new NotFoundException("No t-shirt found @ ID " + id);
        tshirtDao.delete(id);
    }

    @Transactional
    public void updateGame(GameViewModel gvm) {
        Game ug = gameDao.get(gvm.getId());

        if (ug == null)
            throw new NotFoundException("No game found @ ID " + gvm.getId());
        if (gvm.getTitle() != null && gvm.getTitle().equals(""))
            throw new IllegalArgumentException("title must not be empty");
        if (gvm.getTitle() != null)
            ug.setTitle(gvm.getTitle());
        if (gvm.getEsrb_rating() != null && gvm.getEsrb_rating().equals(""))
            throw new IllegalArgumentException("esrb_rating must not be empty");
        if (gvm.getEsrb_rating() != null)
            ug.setEsrb_rating(gvm.getEsrb_rating());
        if (gvm.getDescription() != null && gvm.getDescription().equals(""))
            throw new IllegalArgumentException("description must not be empty");
        if (gvm.getDescription() != null)
            ug.setDescription(gvm.getDescription());
        if (gvm.getPrice() != null && gvm.getPrice().compareTo(min) < 0)
            throw new IllegalArgumentException("price must be greater than or equal to 0");
        if (gvm.getPrice() != null)
            ug.setPrice(gvm.getPrice());
        if (gvm.getStudio() != null && gvm.getStudio().equals(""))
            throw new IllegalArgumentException("studio must not be empty");
        if (gvm.getStudio() != null)
            ug.setStudio(gvm.getStudio());
        if (gvm.getQuantity() != null && gvm.getQuantity().compareTo(min) < 0)
            throw new IllegalArgumentException("quantity must be greater than or equal to 0");
        if (gvm.getQuantity() != null)
            ug.setQuantity(gvm.getQuantity());

        gameDao.update(ug);
    }

    @Transactional
    public void updateConsole(ConsoleViewModel cvm) {
        Console uc = consoleDao.get(cvm.getId());

        if (uc == null)
            throw new NotFoundException("No console found @ ID " + cvm.getId());
        if (cvm.getModel() != null && cvm.getModel().equals(""))
            throw new IllegalArgumentException("model must not be empty");
        if (cvm.getModel() != null)
            uc.setModel(cvm.getModel());
        if (cvm.getManufacturer() != null && cvm.getManufacturer().equals(""))
            throw new IllegalArgumentException("manufacturer must not be empty");
        if (cvm.getManufacturer() != null)
            uc.setManufacturer(cvm.getManufacturer());
        if (cvm.getMemory_amount() != null && cvm.getMemory_amount().equals(""))
            throw new IllegalArgumentException("memory_amount must not be empty");
        if (cvm.getMemory_amount() != null)
            uc.setMemory_amt(cvm.getMemory_amount());
        if (cvm.getProcessor() != null && cvm.getProcessor().equals(""))
            throw new IllegalArgumentException("processor must not be empty");
        if (cvm.getProcessor() != null)
            uc.setProcessor(cvm.getProcessor());
        if (cvm.getPrice() != null && cvm.getPrice().compareTo(min) < 0)
            throw new IllegalArgumentException("price must be greater than or equal to 0");
        if (cvm.getPrice() != null)
            uc.setPrice(cvm.getPrice());
        if (cvm.getQuantity() != null && cvm.getQuantity().compareTo(min) < 0)
            throw new IllegalArgumentException("quantity must be greater than or equal to 0");
        if (cvm.getQuantity() != null)
            uc.setQuantity(cvm.getQuantity());

        consoleDao.update(uc);
    }

    @Transactional
    public void updateTshirt(TshirtViewModel tvm) {
        Tshirt ut = tshirtDao.get(tvm.getId());

        if (ut == null)
            throw new NotFoundException("No t-shirt found @ ID " + tvm.getId());
        if (tvm.getSize() != null && tvm.getSize().equals(""))
            throw new IllegalArgumentException("size must not be empty");
        if (tvm.getSize() != null)
            ut.setSize(tvm.getSize());
        if (tvm.getColor() != null && tvm.getColor().equals(""))
            throw new IllegalArgumentException("color must not be empty");
        if (tvm.getColor() != null)
            ut.setColor(tvm.getColor());
        if (tvm.getDescription() != null && tvm.getDescription().equals(""))
            throw new IllegalArgumentException("description must not be empty");
        if (tvm.getDescription() != null)
            ut.setDescription(tvm.getDescription());
        if (tvm.getPrice() != null && tvm.getPrice().compareTo(min) < 0)
            throw new IllegalArgumentException("price must be greater than or equal to 0");
        if (tvm.getPrice() != null)
            ut.setPrice(tvm.getPrice());
        if (tvm.getQuantity() != null && tvm.getQuantity().compareTo(min) < 0)
            throw new IllegalArgumentException("quantity must be greater than or equal to 0");
        if (tvm.getQuantity() != null)
            ut.setQuantity(tvm.getQuantity());

        tshirtDao.update(ut);
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gvm = new GameViewModel();
        gvm.setId(game.getId());
        gvm.setTitle(game.getTitle());
        gvm.setEsrb_rating(game.getEsrb_rating());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setStudio(game.getStudio());
        gvm.setQuantity(game.getQuantity());

        return gvm;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setId(console.getId());
        cvm.setModel(console.getModel());
        cvm.setManufacturer(console.getManufacturer());
        cvm.setMemory_amount(console.getMemory_amt());
        cvm.setProcessor(console.getProcessor());
        cvm.setPrice(console.getPrice());
        cvm.setQuantity(console.getQuantity());

        return cvm;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {
        TshirtViewModel tvm = new TshirtViewModel();
        tvm.setId(tshirt.getId());
        tvm.setSize(tshirt.getSize());
        tvm.setColor(tshirt.getColor());
        tvm.setDescription(tshirt.getDescription());
        tvm.setPrice(tshirt.getPrice());
        tvm.setQuantity(tshirt.getQuantity());

        return tvm;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItem_type(invoice.getItem_type().toLowerCase());
        ivm.setItem_id(invoice.getItem_id());
        ivm.setUnit_price(invoice.getPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessing_fee(invoice.getProcessing_fee());
        ivm.setTotal(invoice.getTotal());

        return ivm;
    }
}
