package com.github.aznamier.keycloak.event.provider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.keycloak.events.admin.AdminEvent;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@JsonTypeInfo(use = Id.CLASS)
public class EventAdminNotificationMqMsg extends AdminEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = -7367949289101799624L;

    public static EventAdminNotificationMqMsg create(AdminEvent adminEvent) {
        EventAdminNotificationMqMsg msg = new EventAdminNotificationMqMsg();
        msg.setAuthDetails(adminEvent.getAuthDetails());
        msg.setError(adminEvent.getError());
        msg.setOperationType(adminEvent.getOperationType());
        msg.setRealmId(adminEvent.getRealmId());
        msg.setRepresentation(adminEvent.getRepresentation());
        msg.setResourcePath(adminEvent.getResourcePath());
        msg.setResourceType(adminEvent.getResourceType());
        msg.setResourceTypeAsString(adminEvent.getResourceTypeAsString());
        msg.setTime(adminEvent.getTime());
        return msg;
    }


}
