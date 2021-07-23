package com.example.skeleton.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

import java.io.IOException;
import java.util.Map;

public class UserResolver implements TypeIdResolver {

    private JavaType superType;;

    @Override
    public void init(JavaType baseType) {
        superType = baseType;
    }

    @Override
    public String idFromValue(Object value) {
        return null;
    }

    @Override
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        return null;
    }

    @Override
    public String idFromBaseType() {
        return idFromValueAndType(null, superType.getRawClass());
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String type) throws IOException {
        Class<?> subType = null;
        switch (type.toLowerCase()) {
            case "vendor":
                subType = Vendor.class;
                break;
            case "client":
                subType = Client.class;
                break;
            default:
                throw new RuntimeException("Invalid User type");
        }
        return context.constructSpecializedType(superType, subType);
    }

    @Override
    public String getDescForKnownTypeIds() {
        return "";
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return null;
    }

}
