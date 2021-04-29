package com.simran.strategies;

import java.util.List;

public interface ISlotMappingStrategy
{
    String getNextSlot(List<String> slots);
}
