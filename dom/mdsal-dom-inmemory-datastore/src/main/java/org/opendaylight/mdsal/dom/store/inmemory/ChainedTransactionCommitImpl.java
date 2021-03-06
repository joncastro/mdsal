/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.mdsal.dom.store.inmemory;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import org.opendaylight.mdsal.dom.spi.store.SnapshotBackedWriteTransaction;
import org.opendaylight.yangtools.yang.data.api.schema.tree.DataTreeModification;

final class ChainedTransactionCommitImpl extends InMemoryDOMStoreThreePhaseCommitCohort {
    private final DOMStoreTransactionChainImpl txChain;

    ChainedTransactionCommitImpl(final InMemoryDOMDataStore store,
        final SnapshotBackedWriteTransaction<String> transaction,final DataTreeModification modification,
            final DOMStoreTransactionChainImpl txChain) {
        super(store, transaction, modification);
        this.txChain = Preconditions.checkNotNull(txChain);
    }

    @Override
    public ListenableFuture<Void> commit() {
        ListenableFuture<Void> ret = super.commit();
        txChain.transactionCommited(getTransaction());
        return ret;
    }

}