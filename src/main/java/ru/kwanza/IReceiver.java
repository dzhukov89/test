package ru.kwanza;

import java.util.Collection;

/**
 * @author abelski
 */
public interface IReceiver<T extends MessageWrapper> {
    public void receive(Collection<T> messages) throws ReceiverException;
}
