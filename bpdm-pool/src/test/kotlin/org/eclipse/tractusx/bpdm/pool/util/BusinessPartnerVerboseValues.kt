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

package org.eclipse.tractusx.bpdm.pool.util

import com.neovisionaries.i18n.CountryCode
import com.neovisionaries.i18n.LanguageCode
import org.eclipse.tractusx.bpdm.common.dto.AddressType
import org.eclipse.tractusx.bpdm.common.dto.TypeKeyNameVerboseDto
import org.eclipse.tractusx.bpdm.common.model.BusinessStateType
import org.eclipse.tractusx.bpdm.common.model.ClassificationType
import org.eclipse.tractusx.bpdm.common.service.toDto
import org.eclipse.tractusx.bpdm.pool.api.model.*
import org.eclipse.tractusx.bpdm.pool.api.model.response.AddressPartnerCreateVerboseDto
import org.eclipse.tractusx.bpdm.pool.api.model.response.LegalEntityPartnerCreateVerboseDto
import org.eclipse.tractusx.bpdm.pool.api.model.response.LegalEntityWithLegalAddressVerboseDto
import org.eclipse.tractusx.bpdm.pool.api.model.response.SitePartnerCreateVerboseDto
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Test values for response DTOs
 * Numbered values should match with @see SaasValues numbered values for easier testing
 */
object BusinessPartnerVerboseValues {

    private val createdTime1 = LocalDateTime.of(2020, 1, 1, 1, 1)
    val language0 = TypeKeyNameVerboseDto(LanguageCode.undefined, LanguageCode.undefined.getName())
    val language1 = TypeKeyNameVerboseDto(LanguageCode.en, LanguageCode.en.getName())
    val language2 = TypeKeyNameVerboseDto(LanguageCode.de, LanguageCode.de.getName())
    val language3 = TypeKeyNameVerboseDto(LanguageCode.zh, LanguageCode.zh.getName())

    private val country1 = TypeKeyNameVerboseDto(CountryCode.DE, CountryCode.DE.getName())
    private val country2 = TypeKeyNameVerboseDto(CountryCode.FR, CountryCode.FR.getName())
    private val country3 = TypeKeyNameVerboseDto(CountryCode.PL, CountryCode.PL.getName())

    val identifierType1 = TypeKeyNameVerboseDto("VAT_DE", "Steuernummer")
    val identifierType2 = TypeKeyNameVerboseDto("VAT_US", "VAT USA")
    val identifierType3 = TypeKeyNameVerboseDto("VAT_FR", "VAT France")

    val identifier1 =
        LegalEntityIdentifierVerboseDto("ID-XYZ", identifierType1, "Agency X")
    val identifier2 =
        LegalEntityIdentifierVerboseDto("Another ID Value", identifierType2, "Body Y")
    val identifier3 =
        LegalEntityIdentifierVerboseDto("An ID Value", identifierType3, "Official Z")

    val legalForm1 = LegalFormDto(
        technicalKey = "LF1",
        name = "Limited Liability Company",
        abbreviation = "LLC",
    )
    val legalForm2 = LegalFormDto(
        technicalKey = "LF2",
        name = "Gemeinschaft mit beschränkter Haftung",
        abbreviation = "GmbH",
    )
    val legalForm3 = LegalFormDto(
        technicalKey = "LF3",
        name = "股份有限公司",
        abbreviation = "股份有限",
    )

    val statusType1 = TypeKeyNameVerboseDto(BusinessStateType.ACTIVE, BusinessStateType.ACTIVE.getTypeName())
    val statusType2 = TypeKeyNameVerboseDto(BusinessStateType.INACTIVE, BusinessStateType.INACTIVE.getTypeName())
    val statusType3 = TypeKeyNameVerboseDto(BusinessStateType.ACTIVE, BusinessStateType.ACTIVE.getTypeName())

    val leStatus1 = LegalEntityStateVerboseDto(LocalDateTime.of(2020, 1, 1, 0, 0), null, statusType1)
    val leStatus2 = LegalEntityStateVerboseDto(LocalDateTime.of(2019, 1, 1, 0, 0), null, statusType2)
    val leStatus3 = LegalEntityStateVerboseDto(LocalDateTime.of(2018, 1, 1, 0, 0), null, statusType3)

    val siteStatus1 = SiteStateVerboseDto(LocalDateTime.of(2020, 1, 1, 0, 0), null, BusinessStateType.ACTIVE.toDto())
    val siteStatus2 = SiteStateVerboseDto(LocalDateTime.of(2019, 1, 1, 0, 0), null, BusinessStateType.INACTIVE.toDto())
    val siteStatus3 = SiteStateVerboseDto(LocalDateTime.of(2018, 1, 1, 0, 0), null, BusinessStateType.ACTIVE.toDto())

    val classificationType = TypeKeyNameVerboseDto(ClassificationType.NACE, ClassificationType.NACE.name)

    val classification1 = LegalEntityClassificationVerboseDto("Sale of motor vehicles", null, classificationType)
    val classification2 = LegalEntityClassificationVerboseDto("Data processing, hosting and related activities", null, classificationType)
    val classification3 = LegalEntityClassificationVerboseDto("Other information service activities", null, classificationType)
    val classification4 = LegalEntityClassificationVerboseDto("Financial and insurance activities", null, classificationType)
    val classification5 = LegalEntityClassificationVerboseDto("Accounting, bookkeeping and auditing activities; tax consultancy", null, classificationType)

    private val confidenceCriteria1 = ConfidenceCriteriaDto(
        sharedByOwner = true,
        checkedByExternalDataSource = true,
        numberOfBusinessPartners = 1,
        lastConfidenceCheckAt = LocalDateTime.of(2023, 10, 10, 10, 10, 10),
        nextConfidenceCheckAt = LocalDateTime.of(2024, 10, 10, 10, 10, 10),
        confidenceLevel = 10
    )

    private val confidenceCriteria2 = ConfidenceCriteriaDto(
        sharedByOwner = false,
        checkedByExternalDataSource = false,
        numberOfBusinessPartners = 3,
        lastConfidenceCheckAt = LocalDateTime.of(2022, 10, 10, 10, 10, 10),
        nextConfidenceCheckAt = LocalDateTime.of(2025, 10, 10, 10, 10, 10),
        confidenceLevel = 6
    )

    private val confidenceCriteria3 = ConfidenceCriteriaDto(
        sharedByOwner = true,
        checkedByExternalDataSource = false,
        numberOfBusinessPartners = 10,
        lastConfidenceCheckAt = LocalDateTime.of(2021, 10, 10, 10, 10, 10),
        nextConfidenceCheckAt = LocalDateTime.of(2026, 10, 10, 10, 10, 10),
        confidenceLevel = 3
    )

    val address1 = PhysicalPostalAddressVerboseDto(
        geographicCoordinates = null,
        countryVerbose = country1,
        postalCode = "71059 ",
        city = "Böblingen",
        administrativeAreaLevel1Verbose = null,
        administrativeAreaLevel2 = "Böblingen",
        administrativeAreaLevel3 = null,
        district = "Sindelfingen-Ost",
        companyPostalCode = "70547",
        industrialZone = "Industrial Zone One",
        building = "Gebäude eins",
        floor = "Stockerk eins",
        door = "Raum eins",
        street = StreetDto(
            name = "Bela-Barenyi-Straße",
            houseNumber = "1",
            houseNumberSupplement = "A",
            milestone = "milestone 1",
            direction = "direction 1",
            nameSuffix = "name suffix 1",
            namePrefix = "name prefix 1",
            additionalNameSuffix = "add name suffix 1",
            additionalNamePrefix = "add name prefix 1"
        ),
    )

    val address2 = PhysicalPostalAddressVerboseDto(
        geographicCoordinates = null,
        countryVerbose = country2,
        postalCode = "70547",
        city = "Atlanta",
        administrativeAreaLevel1Verbose = null,
        administrativeAreaLevel2 = " Fulton County",
        administrativeAreaLevel3 = null,
        district = "District Level 1",
        companyPostalCode = null,
        industrialZone = "Industrial Zone Two",
        building = "Building Two",
        floor = "Floor Two",
        door = "Door Two",
        street = StreetDto(
            name = "Street2",
            houseNumber = "2",
            houseNumberSupplement = "B",
            milestone = "milestone 2",
            direction = "direction 2",
            nameSuffix = "name suffix 2",
            namePrefix = "name prefix 2",
            additionalNameSuffix = "add name suffix 2",
            additionalNamePrefix = "add name prefix 2"
        )
    )

    val address3 = PhysicalPostalAddressVerboseDto(
        geographicCoordinates = null,
        countryVerbose = country3,
        postalCode = "30346",
        city = "Atlanta",
        administrativeAreaLevel1Verbose = null,
        administrativeAreaLevel2 = " Fulton County",
        administrativeAreaLevel3 = null,
        district = "DL 1",
        companyPostalCode = null,
        industrialZone = "Industrial Zone Three",
        building = "tedifício  três",
        floor = "piso três",
        door = "peça três",
        street = StreetDto(
            name = "Street 3",
            houseNumber = "3",
            houseNumberSupplement = "C",
            milestone = "milestone 3",
            direction = "direction 3",
            nameSuffix = "name suffix 3",
            namePrefix = "name prefix 3",
            additionalNameSuffix = "add name suffix 3",
            additionalNamePrefix = "add name prefix 3"
        ),
    )

    val addressPartner1 = LogisticAddressVerboseDto(
        bpna = "BPNA000000000001",
        physicalPostalAddress = address1,
        bpnLegalEntity = null,
        bpnSite = null,
        confidenceCriteria = confidenceCriteria1,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
        addressType = AddressType.AdditionalAddress
    )

    val addressPartner2 = LogisticAddressVerboseDto(
        bpna = "BPNA0000000001YN",
        physicalPostalAddress = address2,
        bpnLegalEntity = null,
        bpnSite = null,
        confidenceCriteria = confidenceCriteria2,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
        addressType = AddressType.AdditionalAddress
    )

    val addressPartner3 = LogisticAddressVerboseDto(
        bpna = "BPNA0000000002XY",
        physicalPostalAddress = address3,
        bpnLegalEntity = null,
        bpnSite = null,
        confidenceCriteria = confidenceCriteria3,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
        addressType = AddressType.AdditionalAddress
    )

    val addressPartnerCreate1 = AddressPartnerCreateVerboseDto(
        address = addressPartner1,
        index = "1"
    )

    val addressPartnerCreate2 = AddressPartnerCreateVerboseDto(
        address = addressPartner2,
        index = "2"
    )

    val addressPartnerCreate3 = AddressPartnerCreateVerboseDto(
        address = addressPartner3,
        index = "3"
    )

    val site1 = SiteVerboseDto(
        bpns = "BPNS000000000001",
        name = "Stammwerk A",
        states = listOf(siteStatus1),
        bpnLegalEntity = "BPNL000000000001",
        confidenceCriteria = confidenceCriteria1,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
    )

    val site2 = SiteVerboseDto(
        bpns = "BPNS0000000001YN",
        name = "Halle B1",
        states = listOf(siteStatus2),
        bpnLegalEntity = "BPNL0000000001YN",
        confidenceCriteria = confidenceCriteria2,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
    )

    val site3 = SiteVerboseDto(
        bpns = "BPNS0000000002XY",
        name = "主厂房 C",
        states = listOf(siteStatus3),
        bpnLegalEntity = "BPNL0000000002XY",
        confidenceCriteria = confidenceCriteria3,
        createdAt = Instant.now(),
        updatedAt = Instant.now(),
    )

    val siteUpsert1 = SitePartnerCreateVerboseDto(
        site = site1,
        mainAddress = addressPartner1.copy(
            bpnSite = site1.bpns,
            isMainAddress = true,
            addressType = AddressType.SiteMainAddress
        ),
        index = "1"
    )

    val siteUpsert2 = SitePartnerCreateVerboseDto(
        site = site2,
        mainAddress = addressPartner2.copy(
            bpnSite = site2.bpns,
            isMainAddress = true,
            addressType = AddressType.SiteMainAddress
        ),
        index = "2"
    )

    val siteUpsert3 = SitePartnerCreateVerboseDto(
        site = site3,
        mainAddress = addressPartner3.copy(
            bpnSite = site3.bpns,
            isMainAddress = true,
            addressType = AddressType.SiteMainAddress
        ),
        index = "3"
    )


    val legalEntity1 = LegalEntityWithLegalAddressVerboseDto(
        LegalEntityVerboseDto(
            bpnl = "BPNL000000000001",
            legalName = "Business Partner Name",
            legalFormVerbose = legalForm1,
            identifiers = listOf(identifier1),
            states = listOf(leStatus1),
            classifications = listOf(classification1, classification2),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria1,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        ),
        legalAddress = LogisticAddressVerboseDto(
            bpna = "BPNA000000000001",
            physicalPostalAddress = PhysicalPostalAddressVerboseDto(
                geographicCoordinates = null,
                countryVerbose = country1,
                postalCode = null,
                city = "Stuttgart",
                administrativeAreaLevel1Verbose = null,
                administrativeAreaLevel2 = null,
                administrativeAreaLevel3 = null,
                district = null,
                companyPostalCode = null,
                industrialZone = null,
                building = null,
                floor = null,
                door = null,
                street = null,
            ),
            bpnLegalEntity = null,
            bpnSite = null,
            confidenceCriteria = confidenceCriteria1,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    )

    val legalEntity2 = LegalEntityWithLegalAddressVerboseDto(
        LegalEntityVerboseDto(
            bpnl = "BPNL0000000001YN",
            legalName = "Another Organisation Corp",
            legalFormVerbose = legalForm2,
            identifiers = listOf(identifier2),
            states = listOf(leStatus2),
            classifications = listOf(classification3, classification4),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria2,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        ),
        legalAddress = LogisticAddressVerboseDto(
            bpna = "BPNA000000000001",
            physicalPostalAddress = PhysicalPostalAddressVerboseDto(
                geographicCoordinates = null,
                countryVerbose = country2,
                postalCode = null,
                city = "5th Congressional District",
                administrativeAreaLevel1Verbose = null,
                administrativeAreaLevel2 = null,
                administrativeAreaLevel3 = null,
                district = null,
                companyPostalCode = null,
                industrialZone = null,
                building = null,
                floor = null,
                door = null,
                street = null,
            ),
            bpnLegalEntity = null,
            bpnSite = null,
            confidenceCriteria = confidenceCriteria2,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    )

    val legalEntity3 = LegalEntityWithLegalAddressVerboseDto(
        LegalEntityVerboseDto(
            bpnl = "BPNL0000000002XY",
            legalName = "好公司  合伙制企业",
            legalFormVerbose = legalForm3,
            identifiers = listOf(identifier3),
            states = listOf(leStatus3),
            classifications = listOf(classification5),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria3,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        ),
        legalAddress = LogisticAddressVerboseDto(
            bpna = "BPNA000000000001",
            physicalPostalAddress = PhysicalPostalAddressVerboseDto(
                geographicCoordinates = null,
                countryVerbose = country3,
                postalCode = null,
                city = "北京市",
                administrativeAreaLevel1Verbose = null,
                administrativeAreaLevel2 = null,
                administrativeAreaLevel3 = null,
                district = null,
                companyPostalCode = null,
                industrialZone = null,
                building = null,
                floor = null,
                door = null,
                street = null,
            ),
            bpnLegalEntity = null,
            bpnSite = null,
            confidenceCriteria = confidenceCriteria3,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    )

    val legalEntityUpsert1 = LegalEntityPartnerCreateVerboseDto(
        legalEntity = LegalEntityVerboseDto(
            bpnl = "BPNL000000000001",
            legalName = "Business Partner Name",
            legalFormVerbose = legalForm1,
            identifiers = listOf(LegalEntityIdentifierVerboseDto("ID-XYZ", identifierType1, "Agency X")),
            states = listOf(leStatus1),
            classifications = listOf(classification1, classification2),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria1,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        ),
        legalAddress = addressPartner1.copy(
            bpnLegalEntity = legalEntity1.legalEntity.bpnl,
            isLegalAddress = true,
            addressType = AddressType.LegalAddress
        ),
        index = "1"
    )

    val legalEntityUpsert2 = LegalEntityPartnerCreateVerboseDto(
        legalEntity = LegalEntityVerboseDto(
            bpnl = "BPNL0000000001YN",
            legalName = "Another Organisation Corp",
            legalFormVerbose = legalForm2,
            identifiers = listOf(LegalEntityIdentifierVerboseDto("Another ID Value", identifierType2, "Body Y")),
            states = listOf(leStatus2),
            classifications = listOf(classification3, classification4),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria2,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        ),
        legalAddress = addressPartner2.copy(
            bpnLegalEntity = legalEntity2.legalEntity.bpnl,
            isLegalAddress = true,
            addressType = AddressType.LegalAddress
        ),
        index = "2"
    )

    val legalEntityUpsert3 = LegalEntityPartnerCreateVerboseDto(
        legalEntity = LegalEntityVerboseDto(
            bpnl = "BPNL0000000002XY",
            legalName = "好公司  合伙制企业",
            legalFormVerbose = legalForm3,
            identifiers = listOf(LegalEntityIdentifierVerboseDto("An ID Value", identifierType3, "Official Z")),
            states = listOf(leStatus3),
            classifications = listOf(classification5),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria3,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        ),
        legalAddress = addressPartner3.copy(
            bpnLegalEntity = legalEntity3.legalEntity.bpnl,
            isLegalAddress = true,
            addressType = AddressType.LegalAddress
        ),
        index = "3"
    )

    val legalEntityUpsertMultipleIdentifier = LegalEntityPartnerCreateVerboseDto(
        legalEntity = LegalEntityVerboseDto(
            bpnl = "BPNL000000000001",
            legalName = "Business Partner Name",
            legalFormVerbose = legalForm1,
            identifiers = listOf(
                LegalEntityIdentifierVerboseDto("ID-XYZ", identifierType1, "Agency X"),
                LegalEntityIdentifierVerboseDto("Another ID Value", identifierType2, "Body Y")
            ),
            states = listOf(leStatus1),
            classifications = listOf(classification1, classification2),
            currentness = createdTime1.toInstant(ZoneOffset.UTC),
            confidenceCriteria = confidenceCriteria1,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        ),
        legalAddress = addressPartner1.copy(
            bpnLegalEntity = legalEntity1.legalEntity.bpnl,
            isLegalAddress = true
        ),
        index = "1"
    )

}