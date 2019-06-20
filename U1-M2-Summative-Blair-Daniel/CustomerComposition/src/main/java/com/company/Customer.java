package com.company;

public class Customer {
    private boolean isRewardsMember;
    private Address shippingAddress;
    private Address billingAddress;
    private ContactInfo contactInfo;

    public Customer(ContactInfo contactInfo, Address shippingAddress, Address billingAddress, boolean isRewardsMember) {
        this.isRewardsMember = isRewardsMember;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.contactInfo = contactInfo;
    }

    public boolean isRewardsMember() {
        return isRewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        isRewardsMember = rewardsMember;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void printIfRewardsMember(boolean isRewardsMember) {
        if (isRewardsMember) {
            System.out.println("I am a rewards Member!!");
        } else {
            System.out.println("I am NOT a rewards Member.");
        }
        System.out.println("===================");
    }

    public void printCustomerInfo(ContactInfo contactInfo, Address shippingAddress, Address billingAddress) {
        contactInfo.printContactInfo();
        System.out.println("Shipping Address:");
        shippingAddress.printAddress();
        System.out.println("Billing Address:");
        billingAddress.printAddress();
        this.printIfRewardsMember(this.isRewardsMember);
    }
}
