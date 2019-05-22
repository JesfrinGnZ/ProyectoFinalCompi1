//------------------>1era area<--------------------------    

package backend.generacionHtml;
import java_cup.runtime.*;
import static backend.generacionHtml.sym.*;


%% //------------------>2da area<--------------------------    

%public
%class AnalizadorDeCodigoEmbebido
%cup
%cupdebug
%unicode
%line
%column



Salto = \r|\n|\r\n
Espacio = {Salto} | [ \t\f]
Identificador = ([:jletterdigit:] | [_] )+
Digitos= 0|[1-9][:digit:]*

%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
  

%}


%% //------------------>3er area<--------------------------    
 <YYINITIAL>  {


    {Digitos}	{return symbol(NUMERO,yytext());}				

    "VAR"    {return symbol(VAR,yytext());}

    "INTEGER"    {return symbol(INTEGER,yytext());}

    "BOOLEAN"    {return symbol(BOOLEAN,yytext());}

    "STRING"    {return symbol(STRING,yytext());}

    "TRUE"    {return symbol(TRUE,yytext());}

    "FALSE"    {return symbol(FALSE,yytext());}

    "+"    {return symbol(MAS,yytext());}

    "-"    {return symbol(MENOS,yytext());}

    "*"    {return symbol(POR,yytext());}

    "/"    {return symbol(DIV,yytext());}

   ">"    {return symbol(MAYOR,yytext());}

   "<"    {return symbol(MENOR,yytext());}

   ":"    {return symbol(DOS_PUNTOS,yytext());}

   "="    {return symbol(IGUAL,yytext());}

   "("    {return symbol(PARENTESIS_ABIERTO,yytext());}

   ")"    {return symbol(PARENTESIS_CERRADO,yytext());}

   "AND"    {return symbol(AND,yytext());}

   "OR"    {return symbol(OR,yytext());}

   "IF"    {return symbol(IF,yytext());}

   "THEN"    {return symbol(THEN,yytext());}

   "ELSE"    {return symbol(ELSE,yytext());}

   "WHILE"    {return symbol(WHILE,yytext());}

   "FOR"    {return symbol(FOR,yytext());}

   "TO"    {return symbol(TO,yytext());}

   "PRINT"    {return symbol(PRINT,yytext());}

   "BEGIN"    {return symbol(BEGIN,yytext());}

   "END"    {return symbol(END,yytext());}

   ","    {return symbol(COMA,yytext());}

   ";"    {return symbol(PUNTO_COMA,yytext());}

   "["    {return symbol(CORCHETE_ABIERTO,yytext());}

   "]"    {return symbol(CORCHETE_CERRADO,yytext());}

   "%"    {return symbol(PORCENTAJE,yytext());}

//---------------------------------->PARTE HTML<-------------------------
    [h|H][t|T][m|M][l|L]    {return symbol(E_HTML,yytext());}

    [h|H][e|E][a|A][d|D]    {return symbol(E_HEAD,yytext());}

    [t|T][i|I][t|T][l|L][e|E]   {return symbol(E_TITLE,yytext());}

    [b|B][o|O][d|D][y|Y]        {return symbol(E_BODY,yytext());}

    [c|C][e|E][n|N][t|T][e|E][r|R] {return symbol(E_CENTER,yytext());}

    [p|P]                   {return symbol(E_PARRAFO,yytext());}

    [b|B]                    {return symbol(E_NEGRILLA,yytext());}

    [u|U]                    {return symbol(E_SUBRAYADO,yytext());}

    [i|I]                    {return symbol(E_ITALICA,yytext());}

    [s|S][t|T][r|R][i|I][k|K][e|E]                    {return symbol(E_STRIKE,yytext());}

    [b|B][l|L][i|I][n|N][k|K]                    {return symbol(E_BLINK,yytext());}

    [s|S][u|U][b|B]                 {return symbol(E_SUB,yytext());}

    [s|S][u|U][p|P]                 {return symbol(E_SUP,yytext());}

    [f|F][o|O][n|N][t|T]            {return symbol(E_FONT,yytext());}

    [u|U][l|L]                       {return symbol(E_UL,yytext());}
    
    [l|L][i|I]                       {return symbol(E_LI,yytext());}

    [o|O][l|L]                       {return symbol(E_OL,yytext());}

    [b|B][r|R]                      {return symbol(E_BR,yytext());}

    [n|N][o|O][b|B][r|R]            {return symbol(E_NOBR,yytext());}

    [h|H][r|R]                      {return symbol(E_HR,yytext());}

    [b|B][l|L][o|O][c|C][k|K][|q|Q][u|U][o|O][t|T][e|E] {return symbol(E_BLOCKQUOTE,yytext());}
    
    [a|A]                           {return symbol(E_A,yytext());}

    [h|H][r|R][e|E][f|F]        {return symbol(E_HREF,yytext());}

//-----------------------------PROPIEDADES<----------------------------
    [b|B][g|G][c|C][o|O][l|L][o|O][r|R]  {return symbol(BGCOLOR,yytext());}

    [t|T][e|E][x|X][t|T]        {return symbol(TEXT,yytext());} 

    [l|L][i|I][n|N][k|K]        {return symbol(LINK,yytext());}

    [a|A][l|L][i|I][g|G][n|N]   {return symbol(ALIGN,yytext());}
    
    [s|S][i|I][z|Z][e|E]         {return symbol(SIZE,yytext());}

    [f|F][a|A][c|C][e|E]         {return symbol(FACE,yytext());}

    [c|C][o|O][l|L][o|O][r|R]    {return symbol(COLOR,yytext());}

    [t|T][y|Y][p|P][e|E]         {return symbol(TYPE,yytext());}

    [s|S][t|T][a|A][r|R][t|T]   {return symbol(START,yytext());}

    [w|W][i|I][d|D][t|T][h|H]   {return symbol(WIDTH,yytext());}

    [n|N][a|A][m|M][e|E]        {return symbol(NAME,yytext());}

    "&lt"                           {return symbol(LT,"<");}
    "&gt"                           {return symbol(GT,">");}
    "&amp"                          {return symbol(AMP,"&");}
    "&aacute"                       {return symbol(AACUTE,"á");}
    "&eacute"                       {return symbol(EACUTE,"é");}
    "&iacute"                       {return symbol(IACUTE,"í");}
    "&oacute"                       {return symbol(OACUTE,"ó");}
    "&uacute"                       {return symbol(UACUTE," ú");}
    "&Ntilde"                       {return symbol(NTILDEM,"Ñ");}
    "&ntilde"                       {return symbol(NTILDE,"ñ");}
//--------------------------->OTROS<---------------------------
 {Identificador} {return symbol(IDENTIFICADOR,yytext());}

 "'"~"'"      {System.out.println("ORACION EN LEX:"+yytext());return symbol(ORACION,yytext());}  

"\""~"\""     {return symbol(ORACION_TIPO_ATRIBUTO,yytext());}

 "["https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*"]" {return symbol(URL,yytext());}

 

{Espacio} 	{/*IGNORAMOS*/}
}

//<<EOF>>                 { return symbol(EOF);

[^]     {/*Error lexico*/}

