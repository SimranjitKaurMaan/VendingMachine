package com.simran.services;

import com.simran.models.Item;
import com.simran.models.PaymentMode;

public class PaymentService
{
    private VendingService vendingService;

    public PaymentService(VendingService vendingService) {
        this.vendingService = vendingService;
    }

    public void pay(String slotId, Item item, PaymentMode paymentMode)
    {
        switch (paymentMode)
        {
            case card: payViaCard(slotId, item);break;
            case cash: payViaCash(slotId, item);break;
        }

    }

    private void payViaCard(String slotId, Item item)
    {
        System.out.println("Payment via Cash Successful: "+item.getId()+": "+item.getName()+" paid :"+ item.getCost());
        this.vendingService.dispenseItem(slotId,item);
        System.out.println("Item "+item.getName()+" dispensed.");
    }

    private void payViaCash(String slotId,Item item)
    {
        System.out.println("Payment via Cash Successful: "+item.getId()+": "+item.getName()+" paid :"+ item.getCost());
        this.vendingService.dispenseItem(slotId,item);
        System.out.println("Item "+item.getName()+" dispensed.");
    }
}
