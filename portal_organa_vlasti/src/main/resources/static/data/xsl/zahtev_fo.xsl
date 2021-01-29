<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:zah="http://www.ftn.uns.ac.rs/zahtev"
    xmlns:types="http://www.ftn.uns.ac.rs/types"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zahtev_page">
                    <fo:region-body margin-top="1in" margin-bottom="1in"
                        margin-left="80pt" margin-right="80pt"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="zahtev_page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="center" border="none" text-decoration="underline">
                        <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:naziv_organa"/>
                        ,
                        <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:mesto"/>
                        <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:ulica"/>
                        <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block margin-top="0pt" margin-bottom="0pt" 
                        text-align="center" font-size="12pt" font-family="Times New Roman">
                        назив и седиште органа коме се захтев упућује 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" 
                        text-align="center" margin-top="48pt">
                        З А Х Т Е В 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" 
                        text-align="center" margin-top="48pt">
                        за приступ информацији од јавног значаја  
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" margin-top="28pt">
                        На основу члана 15. ст. 1. Закона о слободном приступу информацијама од 
                        јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе
                        наведеног органа захтевам:* 
                    </fo:block>
                        <xsl:for-each select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev">
                            <fo:block text-indent="4em" font-size="12pt" font-family="Times New Roman" margin-top="12pt">
                                <xsl:choose>
                                    <xsl:when test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@checked = 'true'">
                                        <fo:inline font-size="12pt" font-family="MS Gothic">
                                            ☑
                                        </fo:inline>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <fo:inline font-size="12pt" font-family="MS Gothic">
                                            ☐
                                        </fo:inline>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <xsl:value-of select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev"/>
                            </fo:block>
                        </xsl:for-each>
                        <xsl:for-each select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin">
                            <fo:block text-indent="8em" font-size="12pt" font-family="Times New Roman">
                                <xsl:choose>
                                    <xsl:when test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@checked = 'true'">
                                        <fo:inline font-size="12pt" font-family="MS Gothic">
                                            ☑
                                        </fo:inline>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <fo:inline font-size="12pt" font-family="MS Gothic">
                                            ☐
                                        </fo:inline>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <xsl:value-of
                                    select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@tip_dostave"/>
                                <xsl:if test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin[4]">
                                    <fo:inline font-size="12pt" font-family="MS Gothic">
                                        ________________________________
                                        <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/zah:drugi_nacin"/>
                                    </fo:inline>
                                </xsl:if>
                            </fo:block>
                        </xsl:for-each>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" margin-top="12pt">
                        Овај захтев се односи на следеће информације:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" text-decoration="underline" margin-top="10pt">
                        <xsl:value-of select="/zah:dokument_zahtev/zah:informacije/zah:sadrzaj_informacija"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        (навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење
                        тражене информације) 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="-50pt"  text-decoration="underline">
                        У 
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:mesto_i_datum/types:mesto"/>
                        ,
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="20pt"  text-decoration="underline">
                        дана
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:mesto_i_datum/types:datum"/>. године
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="27pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:ime"/>
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Тражилац информације/Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:ulica"/>
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:broj"/>
                        ,
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:mesto"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        адреса
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:drugi_podaci_za_kontakt"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        други подаци за контакт
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:potpis"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Потпис
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify" margin-top="40pt">
                        __________________________________________
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        * У кућици означити која законска права на приступ информацијама желите да остварите. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        ** У кућици означити начин достављања копије докумената.  
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.  
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>  
</xsl:stylesheet>