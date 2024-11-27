package org.apache.synapse.message.store.impl.rabbitmq;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum QueueType {
    QUORUM("quorum"),
    CLASSIC("classic");

    public final String type;

    private QueueType(String type) {
        this.type = type;
    }

    private static final Map<String, QueueType> TYPE_MAP = Arrays.stream(QueueType.values())
            .collect(Collectors.toMap(queueType -> queueType.type.toLowerCase(), queueType -> queueType));

    public static QueueType fromType(String type) {
        QueueType queueType = TYPE_MAP.get(type.toLowerCase());
        if (queueType == null) {
            throw new IllegalArgumentException("No QueueType with type: " + type);
        }
        return queueType;
    }
}