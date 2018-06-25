package de.gedoplan.jackson.system;

import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJPAResolverProvider implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper = new ObjectMapper() {
        private static final long serialVersionUID = 1L;

        {
            JPAResolver resolver = new JPAResolver();
            setHandlerInstantiator(new HandlerInstantiator() {
                @Override
                public JsonDeserializer<?> deserializerInstance(DeserializationConfig config, Annotated annotated, Class<?> deserClass) {
                    return null;
                }

                @Override
                public KeyDeserializer keyDeserializerInstance(DeserializationConfig config, Annotated annotated, Class<?> keyDeserClass) {
                    return null;
                }

                @Override
                public JsonSerializer<?> serializerInstance(SerializationConfig config, Annotated annotated, Class<?> serClass) {
                    return null;
                }

                @Override
                public TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> config, Annotated annotated, Class<?> builderClass) {
                    return null;
                }

                @Override
                public TypeIdResolver typeIdResolverInstance(MapperConfig<?> config, Annotated annotated, Class<?> resolverClass) {
                    return null;
                }

                @Override
                public ObjectIdResolver resolverIdGeneratorInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass) {
                    if (implClass == JPAResolver.class) {
                        return resolver;
                    }

                    return null;
                }

            });
        }
    };

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}
