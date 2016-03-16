/*
 * Copyright 2015-2016 Classmethod, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All source code, documentation and other information
 * contained herein is, and remains the property of Classmethod, Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Classmethod, Inc.
 */
package jp.xet.sparwings.spring.data.chunk;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort.Direction;

/**
 * TODO for daisuke
 * 
 * @since #version#
 * @author daisuke
 */
public interface Chunk<T> extends Iterable<T> {
	
	/**
	 * Returns the page content as {@link List}.
	 * 
	 * @return
	 * @since #version#
	 */
	List<T> getContent();
	
	/**
	 * TODO for daisuke
	 * 
	 * @return
	 * @since #version#
	 */
	Object getLastEvaluatedKey();
	
	/**
	 * Returns the sorting direction for the {@link Chunk}.
	 * 
	 * @return
	 * @since #version#
	 */
	Direction getDirection();
	
	/**
	 * Returns whether the {@link Chunk} has content at all.
	 * 
	 * @return
	 * @since #version#
	 */
	boolean hasContent();
	
	/**
	 * Returns if there is a next {@link Chunk}.
	 * 
	 * @return if there is a next {@link Chunk}.
	 * @since #version#
	 */
	boolean hasNext();
	
	/**
	 * Returns whether the current {@link Chunk} is the last one.
	 * 
	 * @return
	 * @since #version#
	 */
	boolean isLast();
	
	/**
	 * Returns the {@link Chunkable} to request the next {@link Chunk}. Can be {@literal null} in case the current
	 * {@link Chunk} is already the last one. Clients should check {@link #hasNext()} before calling this method to make
	 * sure they receive a non-{@literal null} value.
	 * 
	 * @return
	 * @since #version#
	 */
	Chunkable nextChunkable();
	
	/**
	 * Returns a new {@link Chunk} with the content of the current one mapped by the given {@link Converter}.
	 * 
	 * @param converter must not be {@literal null}.
	 * @return a new {@link Chunk} with the content of the current one mapped by the given {@link Converter}.
	 * @since #version#
	 */
	<S>Chunk<S> map(Converter<? super T, ? extends S> converter);
}