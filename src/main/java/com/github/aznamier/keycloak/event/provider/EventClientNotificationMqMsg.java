package com.github.aznamier.keycloak.event.provider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.keycloak.events.Event;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@JsonTypeInfo(use = Id.CLASS)
public class EventClientNotificationMqMsg extends Event implements Serializable {

    @Serial
    private static final long serialVersionUID = -2192461924304841222L;

    public static EventClientNotificationMqMsg create(Event event) {
        EventClientNotificationMqMsg msg = new EventClientNotificationMqMsg();
        msg.setClientId(event.getClientId());
        msg.setDetails(event.getDetails());
        msg.setError(event.getError());
        msg.setIpAddress(event.getIpAddress());
        msg.setRealmId(event.getRealmId());
        msg.setSessionId(event.getSessionId());
        msg.setTime(event.getTime());
        msg.setType(event.getType());
        msg.setUserId(event.getUserId());

        return msg;
    }


}
