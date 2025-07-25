/*
 * Copyright 2025 LY Corporation
 *
 * LY Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.xds;

import static com.linecorp.armeria.xds.XdsType.ENDPOINT;

import com.linecorp.armeria.common.annotation.Nullable;

import io.envoyproxy.envoy.config.core.v3.ConfigSource;

final class EndpointResourceNode extends AbstractResourceNode<EndpointXdsResource, EndpointSnapshot> {

    EndpointResourceNode(@Nullable ConfigSource configSource,
                         String resourceName, SubscriptionContext context,
                         SnapshotWatcher<EndpointSnapshot> parentWatcher, ResourceNodeType resourceNodeType) {
        super(context, configSource, ENDPOINT, resourceName, parentWatcher, resourceNodeType);
    }

    @Override
    void doOnChanged(EndpointXdsResource update) {
        notifyOnChanged(new EndpointSnapshot(update));
    }
}
