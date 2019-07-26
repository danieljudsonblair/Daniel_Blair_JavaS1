package com.example.DanielBlairU1Capstone.service;

import com.example.DanielBlairU1Capstone.dao.*;
import com.example.DanielBlairU1Capstone.model.*;
import com.example.DanielBlairU1Capstone.viewModel.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InvoiceInventoryServiceTest {

    TshirtDao tshirtDao;
    ConsoleDao consoleDao;
    GameDao gameDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceDao invoiceDao;
    InvoiceInventoryService inventoryService;

    @Before
    public void setUp() throws Exception {

        setUpTshirtDaoMock();
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxDaoMock();


        inventoryService = new InvoiceInventoryService(gameDao, consoleDao, tshirtDao, processingFeeDao, salesTaxRateDao, invoiceDao);
    }

    private void setUpSalesTaxDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate str = new SalesTaxRate();
        str.setState("NC");
        str.setRate(new BigDecimal(".05"));

        doReturn(str).when(salesTaxRateDao).get("NC");
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee pf = new ProcessingFee();
        pf.setProduct_type("t-shirt");
        pf.setFee(new BigDecimal("1.98"));

        doReturn(pf).when(processingFeeDao).get("t-shirt");
    }

    private void setUpTshirtDaoMock() {
        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();
        tshirt.setId(1);
        tshirt.setSize("Large");
        tshirt.setColor("Color");
        tshirt.setDescription("Description");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(new BigDecimal("50"));

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("Large");
        tshirt1.setColor("Color");
        tshirt1.setDescription("Description");
        tshirt1.setPrice(new BigDecimal("19.99"));
        tshirt1.setQuantity(new BigDecimal("50"));

        Tshirt tshirt2 = new Tshirt();
        tshirt2.setId(2);
        tshirt2.setSize("Small");
        tshirt2.setColor("Color");
        tshirt2.setDescription("Updated Description");
        tshirt2.setPrice(new BigDecimal("21.99"));
        tshirt2.setQuantity(new BigDecimal("25"));

        List<Tshirt> tList = new ArrayList<>();
        tList.add(tshirt);

        doReturn(tshirt).when(tshirtDao).add(tshirt1);
        doReturn(tshirt).when(tshirtDao).get(1);
        doReturn(tshirt2).when(tshirtDao).get(2);
        doReturn(tList).when(tshirtDao).getAll();
        doReturn(tList).when(tshirtDao).getByColor("Color");
        doReturn(tList).when(tshirtDao).getBySize("Large");
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setId(1);
        console.setModel("Model");
        console.setManufacturer("Manufacturer");
        console.setMemory_amt("Not much");
        console.setProcessor("Slow");
        console.setPrice(new BigDecimal("89.99"));
        console.setQuantity(new BigDecimal("10"));

        Console console1 = new Console();
        console1.setModel("Model");
        console1.setManufacturer("Manufacturer");
        console1.setMemory_amt("Not much");
        console1.setProcessor("Slow");
        console1.setPrice(new BigDecimal("89.99"));
        console1.setQuantity(new BigDecimal("10"));

        Console console2 = new Console();
        console2.setId(2);
        console2.setModel("Updated Model");
        console2.setManufacturer("Updated Manufacturer");
        console2.setMemory_amt("Updated Not much");
        console2.setProcessor("Updated Slow");
        console2.setPrice(new BigDecimal("99.99"));
        console2.setQuantity(new BigDecimal("20"));

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).add(console1);
        doReturn(console).when(consoleDao).get(1);
        doReturn(cList).when(consoleDao).getAll();
        doReturn(cList).when(consoleDao).getByManufacturer("Manufacturer");
        doReturn(console2).when(consoleDao).get(2);
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setId(1);
        game.setTitle("Title");
        game.setEsrb_rating("Rating");
        game.setDescription("Description");
        game.setPrice(new BigDecimal("9.99"));
        game.setStudio("Studio");
        game.setQuantity(new BigDecimal("50"));

        Game game1 = new Game();
        game1.setTitle("Title");
        game1.setEsrb_rating("Rating");
        game1.setDescription("Description");
        game1.setPrice(new BigDecimal("9.99"));
        game1.setStudio("Studio");
        game1.setQuantity(new BigDecimal("50"));

        Game game2 = new Game();
        game2.setId(2);
        game2.setTitle("Updated Title");
        game2.setEsrb_rating("Updated Rating");
        game2.setDescription("Updated Description");
        game2.setPrice(new BigDecimal("19.99"));
        game2.setStudio("Updated Studio");
        game2.setQuantity(new BigDecimal("25"));

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).add(game1);
        doReturn(game).when(gameDao).get(1);
        doReturn(gList).when(gameDao).getAll();
        doReturn(gList).when(gameDao).getByStudio("Studio");
        doReturn(gList).when(gameDao).getByEsrb("Rating");
        doReturn(gList).when(gameDao).getByTitle("Title");
        doReturn(game2).when(gameDao).get(2);
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setName("name");
        invoice.setStreet("street");
        invoice.setCity("city");
        invoice.setState("NC");
        invoice.setZipcode("28270");
        invoice.setItem_type("t-shirt");
        invoice.setItem_id(1);
        invoice.setPrice(new BigDecimal("19.99"));
        invoice.setQuantity(new BigDecimal("1"));
        invoice.setSubtotal(new BigDecimal("19.99"));
        invoice.setTax(new BigDecimal("1.00"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("22.97"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("name");
        invoice1.setStreet("street");
        invoice1.setCity("city");
        invoice1.setState("NC");
        invoice1.setZipcode("28270");
        invoice1.setItem_type("t-shirt");
        invoice1.setItem_id(1);
        invoice1.setPrice(new BigDecimal("19.99"));
        invoice1.setQuantity(new BigDecimal("1"));
        invoice1.setSubtotal(new BigDecimal("19.99"));
        invoice1.setTax(new BigDecimal("1.00"));
        invoice1.setProcessing_fee(new BigDecimal("1.98"));
        invoice1.setTotal(new BigDecimal("22.97"));

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);

        doReturn(invoice).when(invoiceDao).add(invoice1);
        doReturn(invoice).when(invoiceDao).get(1);
        doReturn(iList).when(invoiceDao).getAll();
    }

    @Test
    public void saveFindGames() {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("Title");
        gvm.setEsrb_rating("Rating");
        gvm.setDescription("Description");
        gvm.setPrice(new BigDecimal("9.99"));
        gvm.setStudio("Studio");
        gvm.setQuantity(new BigDecimal("50"));

        gvm = inventoryService.saveGame(gvm);
        GameViewModel fromService = inventoryService.findGameById(gvm.getId());
        assertEquals(gvm, fromService);

        List<GameViewModel> fromServiceList = inventoryService.findGamesByStudio("Studio");
        assertEquals(fromServiceList.size(), 1);

        fromServiceList = inventoryService.findGamesByESRBRating("Rating");
        assertEquals(fromServiceList.size(), 1);

        fromServiceList = inventoryService.findGamesByTitle("Title");
        assertEquals(fromServiceList.size(), 1);

        fromServiceList = inventoryService.findAllGames();
        assertEquals(fromServiceList.size(), 1);
    }

    @Test
    public void saveFindConsoles() {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Model");
        cvm.setManufacturer("Manufacturer");
        cvm.setMemory_amount("Not much");
        cvm.setProcessor("Slow");
        cvm.setPrice(new BigDecimal("89.99"));
        cvm.setQuantity(new BigDecimal("10"));

        cvm = inventoryService.saveConsole(cvm);
        ConsoleViewModel fromService = inventoryService.findConsoleById(cvm.getId());
        assertEquals(cvm, fromService);

        List<ConsoleViewModel> fromServiceList = inventoryService.findConsolesByManufacturer("Manufacturer");
        assertEquals(fromServiceList.size(), 1);

        fromServiceList = inventoryService.findAllConsoles();
        assertEquals(fromServiceList.size(), 1);
    }

    @Test
    public void saveFindTshirts() {
        TshirtViewModel tvm = new TshirtViewModel();
        tvm.setSize("Large");
        tvm.setColor("Color");
        tvm.setDescription("Description");
        tvm.setPrice(new BigDecimal("19.99"));
        tvm.setQuantity(new BigDecimal("50"));

        tvm = inventoryService.saveTshirt(tvm);
        TshirtViewModel fromService = inventoryService.findTshirtById(tvm.getId());
        assertEquals(tvm, fromService);

        List<TshirtViewModel> fromServiceList = inventoryService.findTshirtsBySize("Large");
        assertEquals(fromServiceList.size(), 1);

        fromServiceList = inventoryService.findTshirtsByColor("Blue");
        assertEquals(fromServiceList.size(), 0);

        fromServiceList = inventoryService.findAllTshirts();
        assertEquals(fromServiceList.size(), 1);
    }

    @Test
    public void updateTshirt() {
        TshirtViewModel tvm = inventoryService.findTshirtById(1);

        tvm.setSize("Small");
        tvm.setColor("Color");
        tvm.setDescription("Updated Description");
        tvm.setPrice(new BigDecimal("21.99"));
        tvm.setQuantity(new BigDecimal("25"));

        inventoryService.updateTshirt(tvm);

        ArgumentCaptor<Tshirt> tshirtCaptor = ArgumentCaptor.forClass(Tshirt.class);
        verify(tshirtDao).update(tshirtCaptor.capture());
        assertEquals(tvm.getDescription(), tshirtCaptor.getValue().getDescription());
    }

    @Test
    public void updateConsole() {
        ConsoleViewModel cvm = inventoryService.findConsoleById(1);

        cvm.setModel("Updated Model");
        cvm.setManufacturer("Updated Manufacturer");
        cvm.setMemory_amount("Updated Not much");
        cvm.setProcessor("Updated Slow");
        cvm.setPrice(new BigDecimal("99.99"));
        cvm.setQuantity(new BigDecimal("20"));

        inventoryService.updateConsole(cvm);

        ArgumentCaptor<Console> consoleCaptor = ArgumentCaptor.forClass(Console.class);
        verify(consoleDao).update(consoleCaptor.capture());
        assertEquals(cvm.getModel(), consoleCaptor.getValue().getModel());
    }

    @Test
    public void updateGame() {
        GameViewModel gvm = inventoryService.findGameById(1);

        gvm.setTitle("Updated Title");
        gvm.setEsrb_rating("Updated Rating");
        gvm.setDescription("Updated Description");
        gvm.setPrice(new BigDecimal("19.99"));
        gvm.setStudio("Updated Studio");
        gvm.setQuantity(new BigDecimal("25"));

        inventoryService.updateGame(gvm);

        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao).update(gameCaptor.capture());
        assertEquals(gvm.getDescription(), gameCaptor.getValue().getDescription());
    }

    @Test
    public void deleteTshirt() {
        TshirtViewModel tvm = inventoryService.findTshirtById(1);
        inventoryService.removeTshirt(1);
        ArgumentCaptor<Integer> tshirtCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(tshirtDao).delete(tshirtCaptor.capture());
        assertEquals(tvm.getId(), tshirtCaptor.getValue().intValue());
    }

    @Test
    public void deleteGame() {
        GameViewModel gvm = inventoryService.findGameById(1);
        inventoryService.removeGame(1);
        ArgumentCaptor<Integer> gameCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(gameDao).delete(gameCaptor.capture());
        assertEquals(gvm.getId(), gameCaptor.getValue().intValue());
    }

    @Test
    public void deleteConsole() {
        ConsoleViewModel cvm = inventoryService.findConsoleById(1);
        inventoryService.removeConsole(1);
        ArgumentCaptor<Integer> consoleCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(consoleDao).delete(consoleCaptor.capture());
        assertEquals(cvm.getId(), consoleCaptor.getValue().intValue());
    }

    @Test
    public void saveFindInvoices() {
        PurchaseViewModel pvm = new PurchaseViewModel();
        pvm.setName("name");
        pvm.setStreet("street");
        pvm.setCity("city");
        pvm.setState("NC");
        pvm.setZipcode("28270");
        pvm.setItem_type("t-shirt");
        pvm.setItem_id(1);
        pvm.setQuantity(new BigDecimal("1"));

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setId(1);
        ivm2.setName("name");
        ivm2.setStreet("street");
        ivm2.setCity("city");
        ivm2.setState("NC");
        ivm2.setZipcode("28270");
        ivm2.setItem_type("t-shirt");
        ivm2.setItem_id(1);
        ivm2.setUnit_price(new BigDecimal("19.99"));
        ivm2.setQuantity(new BigDecimal("1"));
        ivm2.setSubtotal(new BigDecimal("19.99"));
        ivm2.setTax(new BigDecimal("1.00"));
        ivm2.setProcessing_fee(new BigDecimal("1.98"));
        ivm2.setTotal(new BigDecimal("22.97"));

        InvoiceViewModel ivm = inventoryService.saveInvoice(pvm);

        assertEquals(ivm, ivm2);

        InvoiceViewModel fromService = inventoryService.findInvoiceById(ivm2.getId());
        assertEquals(ivm2, fromService);

        List<InvoiceViewModel> fromServiceList = inventoryService.findAllInvoices();
        assertEquals(fromServiceList.size(), 1);
    }
}