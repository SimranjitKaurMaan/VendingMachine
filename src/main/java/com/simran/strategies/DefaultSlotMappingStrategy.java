package com.simran.strategies;

import java.util.List;

public class DefaultSlotMappingStrategy implements ISlotMappingStrategy
{
    @Override
    public String getNextSlot(List<String> slots) {
        return slots.get(0);
    }
}
