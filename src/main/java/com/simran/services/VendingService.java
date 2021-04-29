package com.simran.services;

import com.simran.exceptions.EmptySlotException;
import com.simran.exceptions.NoAvailableSlotsException;
import com.simran.models.Item;
import com.simran.models.Slot;
import com.simran.strategies.ISlotMappingStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class VendingService
{
    Map<String,Slot> slotMap;
    ISlotMappingStrategy slotMappingStrategy;

    public VendingService(int numberOfSlots,int slotCapacity, ISlotMappingStrategy slotMappingStrategy)
    {
        this.slotMappingStrategy = slotMappingStrategy;
        this.slotMap = new HashMap<>(numberOfSlots);
        for(int i=0;i<numberOfSlots;i++)
        {
            Slot slot = new Slot(slotCapacity);
            slotMap.put(slot.getId(),slot);
        }
    }

    public List<String> getAvailableSlots()
    {
        Collection<Slot> slots = slotMap.values();
        List<String> availableSlots = slots.stream().filter(slot -> slot.getSize()<slot.getSlotCapacity()).map(slot->slot.getId()).collect(Collectors.toList());

        if(availableSlots.isEmpty())
        {
            throw new NoAvailableSlotsException();
        }
      return availableSlots;
    }

    public String getNextAvailableSlot()
    {
         return slotMappingStrategy.getNextSlot(getAvailableSlots());
    }

   public void addItem(String slotId, Item item)
   {
       Slot slot = slotMap.get(slotId);
       slot.addItem(item);
   }

    public void dispenseItem(String slotId,Item item)
    {
        Slot slot = slotMap.get(slotId);
        slot.removeItem(item);
    }

   public Item selectItem(String slotId,String itemId)
   {
       Slot slot = slotMap.get(slotId);
      return slot.getItemsMap().get(itemId);
   }

   public List<Item> getAvailableItemsBySlot(String slotId)
   {
     Map<String,Item> itemsMap = slotMap.get(slotId).getItemsMap();
     List<Item> availableItems = itemsMap.values().stream().collect(Collectors.toList());
     if(availableItems.isEmpty())
         throw new EmptySlotException();
     return availableItems;
   }

}
