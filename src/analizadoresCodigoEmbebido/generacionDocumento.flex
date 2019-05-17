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

 {Identificador} {return symbol(IDENTIFICADOR,yytext());}

 "'"~"'"      {return symbol(ORACION,yytext());}  

 "["https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*"]" {return symbol(URL,yytext());}

 

{Espacio} 	{/*IGNORAMOS*/}
}

//<<EOF>>                 { return symbol(EOF);

[^]     {/*Error lexico*/}

