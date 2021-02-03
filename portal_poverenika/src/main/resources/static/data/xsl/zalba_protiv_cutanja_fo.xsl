<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:zpc="http://www.ftn.uns.ac.rs/zalba_protiv_cutanja"
    xmlns:types="http://www.ftn.uns.ac.rs/types"
    version="2.0">
    <xsl:template  match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba_protiv_cutanja_page">
                    <fo:region-body margin-top="0.5in" margin-bottom="0.5in"
                        margin-left="80pt" margin-right="80pt"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="zalba_protiv_cutanja_page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10pt" margin-bottom="0pt" 
                        text-align="center" font-size="10pt" font-weight="bold" font-family="Times New Roman" >
                        ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ
                        ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt" font-weight="bold" 
                        text-align="left" margin-top="20pt">
                        Поверенику за информације од јавног значаја и заштиту података о личности
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"  
                        text-align="left" margin-top="10pt">
                        Адреса за пошту:
                        <xsl:value-of select="zpc:zalba_protiv_cutanja/zpc:primalac_zalbe/types:adresa/types:mesto"/>
                        ,
                        <xsl:value-of select="zpc:zalba_protiv_cutanja/zpc:primalac_zalbe/types:adresa/types:ulica"/>
                        <xsl:value-of select="zpc:zalba_protiv_cutanja/zpc:primalac_zalbe/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="justify" margin-top="30pt">
                        У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:
                    </fo:block>
                    <fo:block margin-top="10pt" margin-bottom="0pt" 
                        text-align="center" font-size="11pt" font-weight="bold" font-family="Times New Roman" >
                        Ж А Л Б У
                    </fo:block>
                    <fo:block margin-top="10pt" text-align="center" font-size="11pt" font-family="Times New Roman" >
                        против
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" text-decoration="underline" margin-top="10pt">
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:informacije_o_zalbi/zpc:naziv_organa"/>
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" >
                        ( навести назив органа)
                    </fo:block>
                    <fo:block margin-top="20pt" text-align="center" font-size="11pt" font-family="Times New Roman" >
                        због тога што орган власти:
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" font-weight="bold">
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:lista_razloga[1]/zpc:razlog[1]"/> /
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:lista_razloga[1]/zpc:razlog[2]"/> /
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:lista_razloga[1]/zpc:razlog[3]"/>
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman">
                        (подвући због чега се изјављује жалба)
                    </fo:block>
                    <fo:block margin-top="20pt" text-align="justify" font-size="11pt" font-family="Times New Roman" >
                        по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том органу дана
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:detalji_zalbe/zpc:datum"/>
                        године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја
                        омогући увид- копија документа који садржи информације о /у вези са :
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-decoration="underline" margin-top="10pt">
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:detalji_zalbe/zpc:podaci_o_zalbi"/>
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman">
                        (навести податке о захтеву и информацији/ама)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" margin-top="28pt">
                        На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им информацији/ма.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" >
                        Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" >
                        Напомена: Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="right" margin-top="27pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:ime"/>
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Подносилац жалбе /Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:potpis"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        Потпис
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:mesto"/> 
                        ,
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:ulica"/>
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        адресa
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:drugi_podaci_za_kontakt"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        други подаци за контакт
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="-100pt"  text-decoration="underline">
                        У 
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:mesto_i_datum/types:mesto"/>
                        ,
                        дана
                        <xsl:value-of
                            select="/zpc:zalba_protiv_cutanja/zpc:mesto_i_datum/types:datum"/>. године
                    </fo:block>
                    
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>