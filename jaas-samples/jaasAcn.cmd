@echo off
setlocal

SET CLASSPATH=%~dp0target

set JAVA="%JAVA_HOME%"\bin\java

set JMAIN="JaasAcn"

set KRB5="-Djava.security.krb5.conf=%~dp0krb5.conf"
set JAAS="-Djava.security.auth.login.config=%~dp0jaas.conf"
REM set GSSAPI="-Dsun.net.spi.nameservice.provider.1=file"

echo call %JAVA% %KRB5% %JAAS% %GSSAPI% -cp "%CLASSPATH%" %JMAIN% %*

endlocal

