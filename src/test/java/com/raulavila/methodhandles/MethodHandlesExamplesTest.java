package com.raulavila.methodhandles;

import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodType.methodType;
import static org.fest.assertions.api.Assertions.assertThat;

public class MethodHandlesExamplesTest {

    private MethodHandles.Lookup lookup = MethodHandles.lookup();
    
    private Item table = new Item("table", 1);
    private Item chair = new Item("chair", 4);
    private Store store = new Store();

    @Before
    public void setUp() throws Exception {
        store.addItem(table);
    }

    @Test
    public void testItemMethodHandles() throws Throwable {
        long start = System.nanoTime();

        MethodHandle methodHandle =
                lookup.findVirtual(Item.class, 
                                    "getName",
                                    methodType(String.class));
        
        Object output = methodHandle.invoke(table);

        long end = System.nanoTime();

        assertThat(output.toString()).isEqualTo("table");

        printExecutionTime("MethodHandles (item), total time", start, end);

    }

    @Test
    public void testItemReflection() throws Throwable {
        long start = System.nanoTime();

        Method method = Item.class.getDeclaredMethod("getName");
        Object output = method.invoke(table);

        long end = System.nanoTime();

        assertThat(output.toString()).isEqualTo("table");

        printExecutionTime("Reflection (item), total time", start, end);
    }

    @Test
    public void testStoreMethodHandles() throws Throwable {
        assertThat(store.getItems()).doesNotContain(chair);

        long start = System.nanoTime();
        
        MethodHandle methodHandle = 
                lookup.findVirtual(Store.class, 
                                    "addItem",      
                                    methodType(void.class, Item.class));
        
        methodHandle.invoke(store, chair);
        
        long end = System.nanoTime();

        assertThat(store.getItems()).contains(chair);

        printExecutionTime("MethodHandles (store), total time", start, end);
    }

    @Test
    public void testStoreReflection() throws Throwable {
        assertThat(store.getItems()).doesNotContain(chair);
        
        long start = System.nanoTime();

        Method method = Store.class.getDeclaredMethod("addItem", Item.class);
        method.invoke(store, chair);

        long end = System.nanoTime();

        assertThat(store.getItems()).contains(chair);

        printExecutionTime("Reflection (store), total time", start, end);
        
    }

    private void printExecutionTime(String message, long start, long end) {
        double timeMilis = (double)(end - start) / 1000000;
        System.out.printf("%s: %s ms%n", message, timeMilis);
    }
}
