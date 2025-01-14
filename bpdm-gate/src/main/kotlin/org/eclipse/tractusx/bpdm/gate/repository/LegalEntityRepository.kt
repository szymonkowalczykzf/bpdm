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

package org.eclipse.tractusx.bpdm.gate.repository

import org.eclipse.tractusx.bpdm.common.model.StageType
import org.eclipse.tractusx.bpdm.gate.entity.LegalEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface LegalEntityRepository : JpaRepository<LegalEntity, Long>, CrudRepository<LegalEntity, Long> {

    fun findDistinctByExternalIdIn(externalId: Collection<String>): Set<LegalEntity>

    fun findByExternalId(externalId: String): LegalEntity?

    fun findByExternalIdAndStage(externalId: String, stage: StageType): LegalEntity?

    fun findByExternalIdInAndStage(externalId: Collection<String>?, stage: StageType, pageable: Pageable): Page<LegalEntity>

    fun findByStage(stage: StageType, pageable: Pageable): Page<LegalEntity>
}