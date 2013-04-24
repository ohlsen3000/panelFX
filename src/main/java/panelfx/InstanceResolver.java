package panelfx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.literal.DefaultLiteral;

public class InstanceResolver {

    private InstanceResolver() {

    }

    public static <T> Instance<T> getInstance(final Class<T> type, final BeanManager manager) {
        return getInstance(type, manager, DefaultLiteral.INSTANCE);
    }

    public static <T> Instance<T> getInstance(final Class<T> type, final BeanManager manager, final Annotation... qualifiers) {
        final Type instanceType = new InstanceParamatizedTypeImpl<T>(type);
        final Bean<?> bean = manager.resolve(manager.getBeans(instanceType, qualifiers));
        final CreationalContext ctx = manager.createCreationalContext(bean);
        return (Instance<T>) manager.getInjectableReference(new InstanceInjectionPoint<T>(type, qualifiers), ctx);
    }

    private static class InstanceParamatizedTypeImpl<T> implements ParameterizedType {

        private final Class<T> type;

        public InstanceParamatizedTypeImpl(final Class<T> type) {
            this.type = type;
        }

        @Override
        public Type[] getActualTypeArguments() {
            final Type[] ret = new Type[1];
            ret[0] = this.type;
            return ret;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

        @Override
        public Type getRawType() {
            return Instance.class;
        }

    }

    /**
     * TODO: this is not portable, needs to be a proper implementation as this
     * could cause a NPE due to some methods returning null
     */
    private static class InstanceInjectionPoint<T> implements InjectionPoint {

        private final Class<T> type;
        private final Set<Annotation> qualifiers;

        public InstanceInjectionPoint(final Class<T> type, final Annotation... quals) {
            this.type = type;
            this.qualifiers = new HashSet<Annotation>();
            for (final Annotation a : quals) {
                this.qualifiers.add(a);
            }
        }

        @Override
        public Annotated getAnnotated() {
            return null;
        }

        @Override
        public Bean<?> getBean() {
            return null;
        }

        @Override
        public Member getMember() {
            return null;
        }

        @Override
        public Set<Annotation> getQualifiers() {

            return this.qualifiers;
        }

        @Override
        public Type getType() {
            return new InstanceParamatizedTypeImpl<T>(this.type);
        }

        @Override
        public boolean isDelegate() {
            return false;
        }

        @Override
        public boolean isTransient() {
            return false;
        }

    }
}
