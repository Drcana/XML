<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0" xmlns:ob="http://www.ftn.uns.ac.rs/obavestenje"
                xmlns:types="http://www.ftn.uns.ac.rs/types">
    <xsl:template match="/">
        <html>

        <head>
            <style>
                .center {
                    margin: 0;
                    position: absolute;
                }

                p,
                ol,
                li {
                    font-family: 'Times New Roman', Times, serif;
                    font-size: 11pt;
                }

                .center_text {
                    text-align: center;
                }

                .field_above_post_address {
                    font-weight: bold;
                    font-size: 12pt;
                    margin-bottom: 0pt;
                }

                .field_post_address {
                    margin-top: 0pt;
                }

                .all_bold {
                    font-weight: bold;
                    font-size: 10pt;
                    text-align: center;
                }

                .font-11 {
                    font-size: 11pt;
                }

                .font-12 {
                    font-size: 12pt;
                }

                .margin_top_bottom_zero {
                    margin-top: 0pt;
                    margin-bottom: 0pt;
                }

                .indented {
                    text-indent: 40pt;
                }

                .right_align {
                    text-align: right;
                    margin-right: 10%;
                }

                .split {
                    float: left;
                }
            </style>
        </head>

        <body class="center">
            <div>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:naziv_organa">
                    </xsl:value-of>
                    <xsl:value-of select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:organ_vlasti/types:adresa">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero"> (назив и седиште органа)</p>
                <p class="margin_top_bottom_zero">Број предмета: <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:broj_predmeta"></xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">Датум: <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:datum_obavestenja"></xsl:value-of>
                </p>
                <p>
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:ime">
                    </xsl:value-of>
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:prezime">
                    </xsl:value-of>
                </p>
                <p>
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:ulica">
                    </xsl:value-of>
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:broj">
                    </xsl:value-of>
                    <xsl:value-of
                        select="/ob:obavestenje/ob:informacije_o_obavestenju/ob:podnosilac_zahteva/types:adresa/types:mesto">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">Име и презиме / назив / и адреса подносиоца захтева</p>
                <br/>
                <p class="all_bold font-12 margin_top_bottom_zero">О Б А В Е Ш Т Е Њ Е</p>
                <p class="all_bold font-11 margin_top_bottom_zero">о стављању на увид документа који садржи</p>
                <p class="all_bold font-11 margin_top_bottom_zero">тражену информацију и о изради копије</p>
                <br/>
                <p class="indented margin_top_bottom_zero">На основу члана 16. ст. 1. Закона о слободном приступу
                    информацијама од јавног значаја, поступајући по вашем захтеву за слободан приступ информацијама од
                    <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:datum_zahteva"></xsl:value-of> год.,
                    којим сте тражили увид у документ/е са информацијама
                    о / у вези са:
                </p>
                <p class="center_text margin_top_bottom_zero">
                    <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:opis_trazene_informacije">
                    </xsl:value-of>
                </p>
                <p class="center_text margin_top_bottom_zero">(опис тражене информације)</p>
                <p>обавештавамо вас да дана <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:datum_uvida">
                    </xsl:value-of>, у <xsl:value-of
                        select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:sati"></xsl:value-of>
                    часова, односно у времену од <xsl:value-of
                        select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:od"></xsl:value-of> до
                    <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:vreme_uvida/ob:od"></xsl:value-of>
                    часова, у просторијама органа у
                    <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:mesto">
                    </xsl:value-of> ул. <xsl:value-of
                        select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:ulica">
                    </xsl:value-of> бр. <xsl:value-of
                        select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:adresa/types:broj">
                    </xsl:value-of>, канцеларија бр. <xsl:value-of
                        select="/ob:obavestenje/ob:tekst_obavestenja/ob:mesto_uvida/ob:broj_kancelarije">
                    </xsl:value-of> можете
                    извршити увид у документ/е у коме је садржана тражена информација.
                </p>
                <p class="indented">Том приликом, на ваш захтев, може вам се издати и копија документа са траженом
                    информацијом.</p>
                <p>Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране
                    А4 формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара,
                    аудио-касета – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког у
                    електронски облик – 30 динара.</p>
                <p class="indented">Износ укупних трошкова израде копије документа по вашем захтеву износи
                    <xsl:value-of select="/ob:obavestenje/ob:tekst_obavestenja/ob:troskovi"></xsl:value-of> динара и
                    уплаћује се на жиро-рачун Буџета Републике Србије бр.
                    840-742328-843-30, с позивом на број 97 – ознака шифре општине/града где се налази орган власти (из
                    Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).
                </p>
                <p class="margin_top_bottom_zero">Достављено:</p>
                <ol>
                    <li>Именованом (М.П.)</li>
                    <li>Архиви</li>
                </ol>
            </div>
            <div class="right_align">
                <p class="margin_top_bottom_zero MENJAJ ME KAJO">
                    <xsl:value-of select="/ob:obavestenje/ob:potpis"></xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">(потпис овлашћеног лица, односно руководиоца органа)</p>
            </div>
        </body>

        </html>
    </xsl:template>
</xsl:stylesheet>