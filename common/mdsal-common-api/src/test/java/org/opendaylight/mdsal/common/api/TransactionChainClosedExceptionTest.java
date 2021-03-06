/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.mdsal.common.api;

import org.junit.Test;

public class TransactionChainClosedExceptionTest {

    @Test(expected = TransactionChainClosedException.class)
    public void transactionChainClosedExceptionTest() throws Exception {
        throw new TransactionChainClosedException("test");
    }

    @Test(expected = TransactionChainClosedException.class)
    public void transactionChainClosedExceptionWithNullCauseTest() throws Exception {
        throw new TransactionChainClosedException("test", null);
    }
}