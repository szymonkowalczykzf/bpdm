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

package org.eclipse.tractusx.bpdm.pool.controller

import org.eclipse.tractusx.bpdm.common.dto.PageDto
import org.eclipse.tractusx.bpdm.common.dto.PaginationRequest
import org.eclipse.tractusx.bpdm.pool.api.PoolAddressApi
import org.eclipse.tractusx.bpdm.pool.api.model.LogisticAddressVerboseDto
import org.eclipse.tractusx.bpdm.pool.api.model.request.AddressPartnerBpnSearchRequest
import org.eclipse.tractusx.bpdm.pool.api.model.request.AddressPartnerCreateRequest
import org.eclipse.tractusx.bpdm.pool.api.model.request.AddressPartnerSearchRequest
import org.eclipse.tractusx.bpdm.pool.api.model.request.AddressPartnerUpdateRequest
import org.eclipse.tractusx.bpdm.pool.api.model.response.AddressMatchVerboseDto
import org.eclipse.tractusx.bpdm.pool.api.model.response.AddressPartnerCreateResponseWrapper
import org.eclipse.tractusx.bpdm.pool.api.model.response.AddressPartnerUpdateResponseWrapper
import org.eclipse.tractusx.bpdm.pool.service.AddressService
import org.eclipse.tractusx.bpdm.pool.service.BusinessPartnerBuildService
import org.eclipse.tractusx.bpdm.pool.service.SearchService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressController(
    private val addressService: AddressService,
    private val businessPartnerBuildService: BusinessPartnerBuildService,
    private val searchService: SearchService
) : PoolAddressApi {

    @PreAuthorize("hasAuthority(@poolSecurityConfigProperties.getReadPoolPartnerDataAsRole())")
    override fun getAddresses(
        addressSearchRequest: AddressPartnerSearchRequest,
        paginationRequest: PaginationRequest
    ): PageDto<AddressMatchVerboseDto> {

        return searchService.searchAddresses(addressSearchRequest, paginationRequest)
    }

    @PreAuthorize("hasAuthority(@poolSecurityConfigProperties.getReadPoolPartnerDataAsRole())")
    override fun getAddress(
        bpna: String
    ): LogisticAddressVerboseDto {
        return addressService.findByBpn(bpna.uppercase())
    }

    @PreAuthorize("hasAuthority(@poolSecurityConfigProperties.getReadPoolPartnerDataAsRole())")
    override fun searchAddresses(
        addressSearchRequest: AddressPartnerBpnSearchRequest,
        paginationRequest: PaginationRequest
    ): PageDto<LogisticAddressVerboseDto> {
        return addressService.findByPartnerAndSiteBpns(addressSearchRequest, paginationRequest)
    }

    @PreAuthorize("hasAuthority(@poolSecurityConfigProperties.getChangePoolPartnerDataAsRole())")
    override fun createAddresses(
        requests: Collection<AddressPartnerCreateRequest>
    ): AddressPartnerCreateResponseWrapper {
        return businessPartnerBuildService.createAddresses(requests)
    }

    @PreAuthorize("hasAuthority(@poolSecurityConfigProperties.getChangePoolPartnerDataAsRole())")
    override fun updateAddresses(
        requests: Collection<AddressPartnerUpdateRequest>
    ): AddressPartnerUpdateResponseWrapper {
        return businessPartnerBuildService.updateAddresses(requests)
    }
}
