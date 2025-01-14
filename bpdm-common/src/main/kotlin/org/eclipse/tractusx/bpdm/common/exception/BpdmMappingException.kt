/*******************************************************************************
 * Copyright (c) 2021,2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.eclipse.tractusx.bpdm.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import kotlin.reflect.KClass

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
open class BpdmMappingException(
    fromType: String,
    toType: String,
    reason: String,
    objectIdentifier: String = "Unknown"
) : RuntimeException("Exception mapping object '$objectIdentifier' from type $fromType to $toType: $reason") {
    constructor(fromType: KClass<*>, toType: KClass<*>, reason: String, objectIdentifier: String = "Unknown") :
            this(fromType.simpleName ?: fromType.toString(), toType.simpleName ?: toType.toString(), reason, objectIdentifier)
}