<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:zah="http://www.ftn.uns.ac.rs/zahtev"
                xmlns:types="http://www.ftn.uns.ac.rs/types">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    .font {
                    font-family: 'MS Gothic';
                    font-size: 20px;
                    }
                    .zahtev-doc {
                    padding: 0 7rem;
                    }

                    .ta-c {
                    text-align: center;
                    }

                    .top-info {
                    padding-top: 20px;
                    background-color: white;
                    font-size: 1.7rem;
                    }

                    .organ-info {
                    margin-top: -10px;
                    }

                    .zahtev-title {
                    font-size: 2.2rem;
                    }

                    .checkbox {
                    font-size: 30px;
                    }

                    .checkboxes {
                    max-width: 90%;
                    margin-left: 8%;
                    margin-right: 12%;
                    }

                    .select {
                    padding: 10px;
                    }

                    .druge-opcije {
                    max-width: 90%;
                    margin-left: 12%;
                    }

                    .info {
                    text-align: left;
                    }

                    .description {
                    font-size: 16px;
                    }

                    .mw-80 {
                    max-width: 80%;
                    margin-left: 8%;
                    margin-right: 12%;
                    }

                    .d-inbl {
                    display: inline-block;
                    width: 49%;
                    }

                    .ta-r {
                    text-align: right;
                    }

                    .footer {
                    font-size: 16px;
                    }
                </style>
            </head>
            <body class='font'>
                <div>
                    <div class="zahtev-doc ta-c">
                        <p class="top-info">
                            <u><xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:naziv_organa"/>,
                                <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:mesto"/>
                                <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:ulica"/>
                                <xsl:value-of select="/zah:dokument_zahtev/zah:organ_vlasti/types:adresa/types:broj"/>
                            </u>
                        </p>
                        <p class="organ-info">назив и седиште органа коме се захтев упућује</p>
                        <p class="zahtev-title">
                            <b>З А Х Т Е В</b>
                        </p>
                        <p>
                            <b>за приступ информацији од јавног значаја</b>
                        </p>
                        <p>
                            На основу члана 15. ст. 1. Закона о слободном приступу
                            информацијама од јавног значаја („Службени гласник РС“, бр.
                            120/04, 54/07, 104/09 и 36/10), од горе наведеног органа
                            захтевам:*
                        </p>
                        <div class="checkboxes">
                            <xsl:for-each select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev">
                                <p class="select">
                                    <xsl:choose>
                                        <xsl:when
                                                test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@checked = 'true'">
                                            <span class="checkbox">
                                                ☑
                                            </span>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <span class="checkbox">
                                                ☐
                                            </span>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                    <xsl:value-of select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev"/>
                                </p>
                            </xsl:for-each>
                            <div class='druge-opcije'>
                                <xsl:for-each
                                        select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin">
                                    <p>
                                        <xsl:choose>
                                            <xsl:when
                                                    test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@checked = 'true'">
                                                <span class="checkbox">
                                                    ☑
                                                </span>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <span class="checkbox">
                                                    ☐
                                                </span>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                        <xsl:value-of
                                                select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/@tip_dostave"/>
                                        <xsl:if test="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin[4]">
                                            <u>
                                                <span>
                                                    <xsl:value-of
                                                            select="/zah:dokument_zahtev/zah:lista_zahteva/zah:zahtev/zah:lista_nacina/zah:nacin/zah:drugi_nacin"/>
                                                </span>
                                            </u>
                                        </xsl:if>
                                    </p>
                                </xsl:for-each>
                            </div>
                        </div>
                        <p class="mw-80">
                            Овај захтев се
                            односи на следеће информације:
                        </p>
                        <p class='mw-80 info'>
                            <u>
                                <xsl:value-of select="/zah:dokument_zahtev/zah:informacije/zah:sadrzaj_informacija"/>
                            </u>
                        </p>
                        <p class="description">(навести што прецизнији опис
                            информације која се
                            тражи
                            као
                            и друге податке који олакшавају
                            проналажење тражене
                            информације)
                        </p>
                    </div>
                    <div class="mw-80">
                        <div class="d-inbl">
                            <p>
                                У
                                <u>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:mesto_i_datum/types:mesto"/>
                                </u>
                                ,

                            </p>
                            <p>
                                дана
                                <u>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:mesto_i_datum/types:datum"/>
                                </u>
                                . године
                            </p>
                        </div>
                        <div class="d-inbl ta-r">
                            <p>
                                <u>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:ime"/>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:prezime"/>
                                </u>
                            </p>
                            <p>Тражилац информације/Име и презиме</p>
                            <p>
                                <u>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:ulica"/>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:broj"/>
                                    ,
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:adresa/types:mesto"/>
                                </u>
                            </p>
                            <p>адресa</p>
                            <p>
                                <u>
                                    <xsl:value-of
                                            select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:drugi_podaci_za_kontakt"/>
                                </u>
                            </p>
                            <p>други подаци за контакт</p>
                            <u>
                                <xsl:value-of
                                        select="/zah:dokument_zahtev/zah:podnosilac_zahteva/types:potpis"/>
                            </u>

                            <p>Потпис</p>
                        </div>
                        <div class="footer">
                            <hr/>
                            <p>* У кућици означити која законска права на приступ
                                информацијама желите да остварите.
                            </p>
                            <p>** У кућици означити начин достављања копије
                                докумената.
                            </p>
                            <p>*** Када захтевате други начин достављања обавезно
                                уписати који начин достављања захтевате.
                            </p>
                        </div>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>