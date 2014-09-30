package ru.kwanza;

import java.util.Collection;

/**
 * @author abelski
 */
public interface ISender<T extends MessageWrapper> {
    public void put(Collection<T> messages, AbstractCallback callback) throws SenderException;
    public Collection<T> tryPut(Collection<T> messages, AbstractCallback callback) throws SenderException;
}
