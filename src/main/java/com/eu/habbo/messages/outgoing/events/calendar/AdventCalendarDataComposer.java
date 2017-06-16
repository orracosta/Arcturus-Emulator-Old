package com.eu.habbo.messages.outgoing.events.calendar;

import com.eu.habbo.messages.ServerMessage;
import com.eu.habbo.messages.outgoing.MessageComposer;
import com.eu.habbo.messages.outgoing.Outgoing;

public class AdventCalendarDataComposer extends MessageComposer
{
    public final String eventName;
    public final int totalDays;
    public final int currentDay;
    public final int[] unlocked;
    public final int[] expired;

    public AdventCalendarDataComposer(String eventName, int totalDays, int currentDay, int[] unlocked, int[] expired)
    {
        this.eventName = eventName;
        this.totalDays = totalDays;
        this.currentDay = currentDay;
        this.unlocked = unlocked;
        this.expired = expired;
    }

    @Override
    public ServerMessage compose()
    {
        this.response.init(Outgoing.AdventCalendarDataComposer);
        this.response.appendString(this.eventName);
        this.response.appendString(this.eventName);
        this.response.appendInt(this.currentDay);
        this.response.appendInt(this.totalDays);

        this.response.appendInt(this.unlocked.length);
        for (int unlocked : this.unlocked)
        {
            this.response.appendInt(unlocked);
        }

        this.response.appendInt(this.expired.length);
        for (int expired : this.expired)
        {
            this.response.appendInt(expired);
        }

        return this.response;
    }
}