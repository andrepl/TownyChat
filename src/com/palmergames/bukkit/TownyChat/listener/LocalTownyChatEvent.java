package com.palmergames.bukkit.TownyChat.listener;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.ensifera.animosity.craftirc.RelayedMessage;
import com.palmergames.bukkit.towny.object.Resident;

public class LocalTownyChatEvent {
  private AsyncPlayerChatEvent event;
  private Resident resident;
  private RelayedMessage rmsg;
  private String format = null;
  
  public LocalTownyChatEvent(AsyncPlayerChatEvent event, Resident resident) {
    this.event = event;
    this.resident = resident;
  }
  
  public LocalTownyChatEvent(RelayedMessage msg, Resident resident) {
	  this.event = null;
	  this.resident = resident;
	  this.rmsg = msg;
  }

  /**
   * Get the resident associated with the chat event's talking player.
   * @return resident associated with the chat event's talking player
   */
  public Resident getResident() {
    return resident;
  }
  
  /**
   * 
   * @return the PlayerChatEvent
   */
  public AsyncPlayerChatEvent getEvent() {
    return event;
  }
  
  
  /**
   * Convenience method for setting the chat event's format.
   * @param format
   */
  public void setFormat(String format) {
	  this.format = format;
	  if (event != null) {
		  event.setFormat(format);
	  }
  }
  
  /**
   * Convenience method for getting the chat event's format
   * @return the chat event's format
   */
  public String getFormat() {
	if (event != null) {
		return event.getFormat();
	}
	return this.format;
  }
  
  /**
   * Convenience method for getting the chat event's message
   * @return the chat event's message
   */
  public String getMessage() {
	if (event != null) {
		return event.getMessage();
	}
	return rmsg.getMessage();
  }
}
