<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:ob="http://www.ftn.uns.ac.rs/obavestenje"
    xmlns:types="http://www.ftn.uns.ac.rs/types"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="obavestenje_page">
                    <fo:region-body margin-top="0.5in" margin-bottom="0.5in"
                        margin-left="80pt" margin-right="80pt"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="obavestenje_page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" text-decoration="underline" margin-top="30pt">
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:naziv_organa"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" text-decoration="underline" >
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:adresa/types:mesto"/>
                        , 
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:adresa/types:ulica"/>

                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block text-align="left" font-size="11pt" font-family="Times New Roman" >
                        ( навести назив органа)
                    </fo:block>
                    <fo:block text-align="left" font-size="11pt" font-family="Times New Roman" >
                        Број предмета:
                        <fo:inline font-size="11pt" font-family="Times New Roman" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:broj_predmeta"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block text-align="left" font-size="11pt" font-family="Times New Roman" >
                        Датум:         
                        <fo:inline font-size="11pt" font-family="Times New Roman" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:datum_obavestenja"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" margin-top="20"
                        text-align="left" text-decoration="underline" >
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:ime"/>

                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:prezime"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" 
                        text-align="left" text-decoration="underline" >
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:mesto"/>
                        , 
                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:ulica"/>

                        <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:broj"/>
                    </fo:block>
                    <fo:block text-align="left" font-size="11pt" font-family="Times New Roman" >
                        Име и презиме / назив / и адреса подносиоца захтева 
                    </fo:block>
                    <fo:block margin-top="20pt" margin-bottom="0pt" 
                        text-align="center" font-size="12pt" font-weight="bold" font-family="Times New Roman" >
                        О Б А В Е Ш Т Е Њ Е 
                    </fo:block>
                    <fo:block  text-align="center" font-size="11pt" font-weight="bold" font-family="Times New Roman" >
                        о стављању на увид документа који садржи 
                        тражену информацију и о изради копије 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" margin-top="20pt">
                        На основу члана 16. ст. 1. Закона о слободном приступу информацијама од јавног значаја,
                        поступајући по вашем захтеву за слободан приступ информацијама од
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:datum_zahteva"/>
                        </fo:inline>
                        год. , којим сте тражили увид у документ/е са информацијама о / у вези са:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-decoration="underline">
                        <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:opis_trazene_informacije"/>
                    </fo:block>
                    <fo:block text-align="center" font-size="11pt" font-family="Times New Roman" >
                        (опис тражене информације) 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" margin-top="20" >
                        обавештавамо вас да дана
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:datum_uvida"/>
                        </fo:inline>
                        , y
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:sati"/>
                        </fo:inline>
                        часова, односно у времену од
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:od"/>
                        </fo:inline>
                        до 
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:do"/>
                        </fo:inline>
                        часова, у просторијама органа у
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:mesto"/>
                        </fo:inline>
                        ул.
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:ulica"/>
                        </fo:inline>
                        бр. 
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:broj"/>
                        </fo:inline>
                        , канцеларија бр.
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:broj_kancelarije"/>
                        </fo:inline>
                        можете извршити увид у документ/е у коме је садржана тражена информација. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" margin-top="20pt">
                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом. 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" margin-top="20pt">
                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то:
                        копија стране А4 формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 
                        динара, DVD 40 динара, аудио-касета – 150 динара, видео-касета 300 динара, претварање 
                        једне стране документа из физичког у електронски облик – 30 динара.  
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="4em" margin-top="20pt">
                        Износ укупних трошкова израде копије документа по вашем захтеву износи
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-decoration="underline">
                            <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:troskovi"/>
                        </fo:inline>
                        динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30,
                        с позивом на број 97 – ознака шифре општине/града где се налази орган власти
                        (из Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" margin-top="20pt">
                        Достављено: 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" >
                        1.    Именованом 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="left" >
                        2.    Архиви 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="right" margin-top="-20pt" text-decoration="underline">
                        <xsl:value-of select="/ob:obavestenje/ob:potpis"/> 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="right">
                        (потпис овлашћеног лица, односно руководиоца органа)
                    </fo:block>
                </fo:flow>
                
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>