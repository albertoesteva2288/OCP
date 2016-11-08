/**
 * Copyright 2008 Atlassian Pty Ltd
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.atlassian.fugue.auc;

import java.util.concurrent.CountDownLatch;

/**
 * Class exists to support testing LazyReference it is not intended for general
 * use. See atlassian.util.concurrent.ReusableLatch
 * <p>
 * A Latch that may be reused, unlike a {@link CountDownLatch}.
 */
public interface ReusableLatch extends Awaitable {
    /**
     * Release the latch, releasing one or more threads that are waiting on it.
     */
    void release();
}