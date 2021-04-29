import com.simran.models.Item;
import com.simran.models.PaymentMode;
import com.simran.services.PaymentService;
import com.simran.services.VendingService;
import com.simran.strategies.DefaultSlotMappingStrategy;
import com.simran.strategies.ISlotMappingStrategy;
import org.junit.Test;

import java.util.List;

public class VendingServiceTest
{
    @Test
  public void defaultTest()
  {
      ISlotMappingStrategy slotMappingStrategy = new DefaultSlotMappingStrategy();
      VendingService vendingService = new VendingService(2,2,slotMappingStrategy);
      String slotId = vendingService.getNextAvailableSlot();
      Item item1 = new Item("A",10.0);
      vendingService.addItem(slotId,item1);
      slotId = vendingService.getNextAvailableSlot();
      Item item2 = new Item("B",20.0);
      vendingService.addItem(slotId,item2);
      List<Item> items = vendingService.getAvailableItemsBySlot(slotId);
      System.out.println(items);
      Item item = vendingService.selectItem(slotId,items.get(0).getId());
      PaymentService paymentService = new PaymentService(vendingService);
      paymentService.pay(slotId,item,PaymentMode.card);
      items = vendingService.getAvailableItemsBySlot(slotId);
      System.out.println(items);
      item = vendingService.selectItem(slotId,items.get(0).getId());
      paymentService.pay(slotId,item,PaymentMode.cash);
      slotId = vendingService.getNextAvailableSlot();;
      Item item3 = new Item("C",30.0);
      vendingService.addItem(slotId,item3);
      slotId = vendingService.getNextAvailableSlot();
      Item item4 = new Item("D",40.0);
      vendingService.addItem(slotId,item4);
      slotId = vendingService.getNextAvailableSlot();
      Item item5 = new Item("E",50.0);
      vendingService.addItem(slotId,item5);
      items = vendingService.getAvailableItemsBySlot(slotId);
      item = vendingService.selectItem(slotId,items.get(0).getId());
      paymentService.pay(slotId,item,PaymentMode.card);

  }
}
