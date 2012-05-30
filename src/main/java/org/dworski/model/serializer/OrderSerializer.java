package org.dworski.model.serializer;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.dworski.model.Order;

import java.io.IOException;

public class OrderSerializer extends JsonSerializer<Order> {

    @Override
    public Class<Order> handledType() {
        return Order.class;
    }

    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", String.valueOf(order.getId()));
        jsonGenerator.writeArrayFieldStart("cell");
        jsonGenerator.writeNumber(order.getId());
        jsonGenerator.writeString(order.getUserId());
        jsonGenerator.writeString(order.getPrice().toString());
        jsonGenerator.writeString(order.getInvoiceNumber());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
