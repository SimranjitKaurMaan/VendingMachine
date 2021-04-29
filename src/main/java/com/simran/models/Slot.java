package com.simran.models;

import com.simran.exceptions.ItemNotFoundException;
import com.simran.exceptions.SlotFullException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Slot
{
    private String id;
    private int slotCapacity;
    private Map<String,Item> itemsMap;

    public Map<String, Item> getItemsMap() {
        return itemsMap;
    }


    public int getSlotCapacity() {
        return slotCapacity;
    }

    public Slot(int slotCapacity)
    {
        this.id = UUID.randomUUID().toString();
        this.slotCapacity = slotCapacity;
        this.itemsMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public int getSize()
    {
        return itemsMap.size();
    }

    public void addItem(Item item)
    {
        if(itemsMap.size()>slotCapacity)
        {
            throw new SlotFullException();
        }

        itemsMap.put(item.getId(),item);
    }

    public void removeItem(Item item)
    {
        if(!itemsMap.containsKey(item.getId()))
        {
            throw new ItemNotFoundException();
        }
        itemsMap.remove(item.getId());
    }
}
