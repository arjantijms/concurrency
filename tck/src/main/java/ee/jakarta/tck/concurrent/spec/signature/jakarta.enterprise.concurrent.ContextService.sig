#public abstract interface jakarta.enterprise.concurrent.ContextService
public abstract <R> java.util.concurrent.Callable<R> jakarta.enterprise.concurrent.ContextService.contextualCallable(java.util.concurrent.Callable<R>)
public abstract <R> java.util.function.Supplier<R> jakarta.enterprise.concurrent.ContextService.contextualSupplier(java.util.function.Supplier<R>)
public abstract <T,R> java.util.function.Function<T, R> jakarta.enterprise.concurrent.ContextService.contextualFunction(java.util.function.Function<T, R>)
public abstract <T,U,R> java.util.function.BiFunction<T, U, R> jakarta.enterprise.concurrent.ContextService.contextualFunction(java.util.function.BiFunction<T, U, R>)
public abstract <T,U> java.util.function.BiConsumer<T, U> jakarta.enterprise.concurrent.ContextService.contextualConsumer(java.util.function.BiConsumer<T, U>)
public abstract <T> T jakarta.enterprise.concurrent.ContextService.createContextualProxy(T,java.lang.Class<T>)
public abstract <T> T jakarta.enterprise.concurrent.ContextService.createContextualProxy(T,java.util.Map<java.lang.String, java.lang.String>,java.lang.Class<T>)
public abstract <T> java.util.concurrent.CompletableFuture<T> jakarta.enterprise.concurrent.ContextService.withContextCapture(java.util.concurrent.CompletableFuture<T>)
public abstract <T> java.util.concurrent.CompletionStage<T> jakarta.enterprise.concurrent.ContextService.withContextCapture(java.util.concurrent.CompletionStage<T>)
public abstract <T> java.util.function.Consumer<T> jakarta.enterprise.concurrent.ContextService.contextualConsumer(java.util.function.Consumer<T>)
public abstract java.lang.Object jakarta.enterprise.concurrent.ContextService.createContextualProxy(java.lang.Object,java.lang.Class<?>...)
public abstract java.lang.Object jakarta.enterprise.concurrent.ContextService.createContextualProxy(java.lang.Object,java.util.Map<java.lang.String, java.lang.String>,java.lang.Class<?>...)
public abstract java.lang.Runnable jakarta.enterprise.concurrent.ContextService.contextualRunnable(java.lang.Runnable)
public abstract java.util.Map<java.lang.String, java.lang.String> jakarta.enterprise.concurrent.ContextService.getExecutionProperties(java.lang.Object)
public abstract java.util.concurrent.Executor jakarta.enterprise.concurrent.ContextService.currentContextExecutor()