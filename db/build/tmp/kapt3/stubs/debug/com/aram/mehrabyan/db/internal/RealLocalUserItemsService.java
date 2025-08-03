package com.aram.mehrabyan.db.internal;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH\u0016J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/aram/mehrabyan/db/internal/RealLocalUserItemsService;", "Lcom/aram/mehrabyan/db/api/LocalUserItemsService;", "dao", "Lcom/aram/mehrabyan/db/internal/UserItemDao;", "dispatchers", "Lcom/aram/mehrabyan/core/coroutines/AppDispatchers;", "(Lcom/aram/mehrabyan/db/internal/UserItemDao;Lcom/aram/mehrabyan/core/coroutines/AppDispatchers;)V", "delete", "", "item", "Lcom/aram/mehrabyan/db/api/UserItemEntity;", "(Lcom/aram/mehrabyan/db/api/UserItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "insert", "db_debug"})
public final class RealLocalUserItemsService implements com.aram.mehrabyan.db.api.LocalUserItemsService {
    @org.jetbrains.annotations.NotNull()
    private final com.aram.mehrabyan.db.internal.UserItemDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aram.mehrabyan.core.coroutines.AppDispatchers dispatchers = null;
    
    public RealLocalUserItemsService(@org.jetbrains.annotations.NotNull()
    com.aram.mehrabyan.db.internal.UserItemDao dao, @org.jetbrains.annotations.NotNull()
    com.aram.mehrabyan.core.coroutines.AppDispatchers dispatchers) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.aram.mehrabyan.db.api.UserItemEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.aram.mehrabyan.db.api.UserItemEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.aram.mehrabyan.db.api.UserItemEntity>> getAll() {
        return null;
    }
}