<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:zpo="http://www.ftn.uns.ac.rs/zalba_protiv_odluke"
    xmlns:types="http://www.ftn.uns.ac.rs/types"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba_protiv_odluke_page">
                    <fo:region-body margin-top="0.5in" margin-bottom="0.5in"
                        margin-left="80pt" margin-right="80pt"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="zalba_protiv_odluke_page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10pt" margin-bottom="0pt" 
                        text-align="center" font-size="10pt" font-weight="bold" font-family="Times New Roman" >
                        ЖАЛБА ПРОТИВ ОДЛУКЕ ОРГАНА ВЛАСТИ КОЈОМ ЈЕ
                        ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt" font-weight="bold" 
                        text-align="left" margin-top="20pt">
                        Поверенику за информације од јавног значаја и заштиту података о личности
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"  
                        text-align="left" margin-top="10pt">
                        Адреса за пошту:
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:primalac_zalbe/types:adresa/types:mesto"/>
                        ,
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:primalac_zalbe/types:adresa/types:ulica"/>
                        
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:primalac_zalbe/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block margin-top="30pt" margin-bottom="0pt" 
                        text-align="center" font-size="11pt" font-weight="bold" font-family="Times New Roman" >
                        Ж А Л Б А
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" text-decoration="underline" margin-top="10pt">
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:naziv"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" text-decoration="underline" >
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:mesto"/> 
                        ,
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:ulica"/>
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:broj"/>
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" >
                        ( Име, презиме, односно назив, адреса и седиште жалиоца)
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" margin-top="10pt">
                        против решења-закључка
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" text-decoration="underline" >
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:naziv_organa"/> 
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" >
                        (назив органа који је донео одлуку) 
                    </fo:block>
                    <fo:block text-align="left" font-size="11pt" font-family="Times New Roman" margin-top="10pt" 
                        text-decoration="underline">
                        Број
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:broj_resenja"/>
                        од 
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:datum"/> године.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" margin-top="28pt" >
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми
                        са елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-
                        упутио/ла дана
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:detalji_zalbe/zpo:datum"/>
                        године и тако ми ускраћено-онемогућено остваривање уставног и
                        законског права на слободан приступ информацијама од јавног значаја.
                        Oдлуку побијам у целости, односно у делу којим
                        <fo:inline  font-family="Times New Roman" font-size="11pt"
                            text-align="justify" text-decoration="underline">
                            <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:detalji_zalbe/zpo:razlog_zalbe"/>
                        </fo:inline>
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" >
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  
                        поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" >
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о 
                        слободном приступу информацијама од јавног значаја. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="right" margin-top="27pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:ime"/>
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Подносилац жалбе /Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:mesto"/> 
                        ,
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:ulica"/>
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        адресa
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:drugi_podaci_za_kontakt"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        други подаци за контакт
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:potpis"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Потпис
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="-100pt"  text-decoration="underline">
                        У 
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:mesto_i_datum/types:mesto"/>
                        ,
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="20pt"  text-decoration="underline">
                        дана
                        <xsl:value-of
                            select="/zpo:zalba_protiv_odluke/zpo:mesto_i_datum/types:datum"/>. године
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" margin-top="50pt" font-weight="bold">
                        Напомена: 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" >
                        - У жалби се мора навести одлука која се побија (решење, закључак, обавештење), 
                        органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби
                        у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                        Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.  
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="justify">
                        - Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој
                        предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.   
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
        
    </xsl:template>
</xsl:stylesheet>
