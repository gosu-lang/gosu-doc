package gw.gosudoc;

import gw.lang.Gosu;
import gw.lang.cli.CommandLineAccess;
import gw.lang.reflect.ReflectUtil;
import gw.lang.reflect.TypeSystem;

import java.io.IOException;
import java.util.Arrays;

public class GosuDoc
{
  public static void main( String[] args ) throws IOException
  {
    Gosu.bootstrapGosuWhenInitiatedViaClassfile();
    Object gosuDocArgs = TypeSystem.getByFullName( "gw.gosudoc.cli.GosuDocArgs" );
    CommandLineAccess.setRawArgs( Arrays.asList(args) );
    CommandLineAccess.initialize( gosuDocArgs, true );
    Object gsDocHTMLWriter = ReflectUtil.construct( "gw.gosudoc.GSDocHTMLWriter" );
    ReflectUtil.invokeMethod( gsDocHTMLWriter, "write" );
  }
}