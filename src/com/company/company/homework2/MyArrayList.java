package com.company.company.homework2;

/*
 * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */



import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import jdk.internal.access.SharedSecrets;

 public class MyArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
     private static final long serialVersionUID = 8683452581122892189L;


     private static final int DEFAULT_CAPACITY = 10;


     private static final Object[] EMPTY_ELEMENTDATA = {};

     private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


     transient Object[] elementData; // non-private to simplify nested class access

     private int size;


     public MyArrayList(int initialCapacity) {
         if (initialCapacity > 0) {
             this.elementData = new Object[initialCapacity];
         } else if (initialCapacity == 0) {
             this.elementData = EMPTY_ELEMENTDATA;
         } else {
             throw new IllegalArgumentException("Illegal Capacity: " +
                     initialCapacity);
         }
     }

     public MyArrayList() {
         this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     }

     @Override
     public E get(int index) {
         return null;
     }

     @Override
     public void forEach(Consumer<? super E> action) {
         super.forEach(action);
     }

     @Override
     public Spliterator<E> spliterator() {
         return List.super.spliterator();
     }

     @Override
     public Stream<E> stream() {
         return super.stream();
     }

     @Override
     public Stream<E> parallelStream() {
         return super.parallelStream();
     }

     public MyArrayList(Collection<? extends E> c) {
         Object[] a = c.toArray();
         if ((size = a.length) != 0) {
             if (c.getClass() == java.util.ArrayList.class) {
                 elementData = a;
             } else {
                 elementData = Arrays.copyOf(a, size, Object[].class);
             }
         } else {
             // replace with empty array.
             elementData = EMPTY_ELEMENTDATA;
         }
     }

     public void trimToSize() {
         modCount++;
         if (size < elementData.length) {
             elementData = (size == 0)
                     ? EMPTY_ELEMENTDATA
                     : Arrays.copyOf(elementData, size);
         }
     }


     public void ensureCapacity(int minCapacity) {
         if (minCapacity > elementData.length
                 && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                 && minCapacity <= DEFAULT_CAPACITY)) {
             modCount++;
             grow(minCapacity);
         }
     }

     private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


     private Object[] grow(int minCapacity) {
         return elementData = Arrays.copyOf(elementData,
                 newCapacity(minCapacity));
     }

     private Object[] grow() {
         return grow(size + 1);
     }


     private int newCapacity(int minCapacity) {
         // overflow-conscious code
         int oldCapacity = elementData.length;
         int newCapacity = oldCapacity + (oldCapacity >> 1);
         if (newCapacity - minCapacity <= 0) {
             if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                 return Math.max(DEFAULT_CAPACITY, minCapacity);
             if (minCapacity < 0) // overflow
                 throw new OutOfMemoryError();
             return minCapacity;
         }
         return (newCapacity - MAX_ARRAY_SIZE <= 0)
                 ? newCapacity
                 : hugeCapacity(minCapacity);
     }

     private static int hugeCapacity(int minCapacity) {
         if (minCapacity < 0) // overflow
             throw new OutOfMemoryError();
         return (minCapacity > MAX_ARRAY_SIZE)
                 ? Integer.MAX_VALUE
                 : MAX_ARRAY_SIZE;
     }


     public int size() {
         return size;
     }


     public boolean isEmpty() {
         return size == 0;
     }

     public boolean contains(Object o) {
         return indexOf(o) >= 0;
     }

     @Override
     public <T> T[] toArray(IntFunction<T[]> generator) {
         return super.toArray(generator);
     }

     @Override
     public boolean removeIf(Predicate<? super E> filter) {
         return super.removeIf(filter);
     }

     @Override
     public void replaceAll(UnaryOperator<E> operator) {
         List.super.replaceAll(operator);
     }

     @Override
     public void sort(Comparator<? super E> c) {
         List.super.sort(c);
     }
 }

