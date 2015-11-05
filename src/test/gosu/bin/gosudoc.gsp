uses java.io.File

uses gw.lang.cli.CommandLineAccess
uses gw.gosudoc.GSDocHTMLWriter
uses gw.gosudoc.cli.GosuDocArgs

print("Starting GosuDoc...")
print("Args: ${CommandLineAccess.RawArgs.join( " " )}")

CommandLineAccess.initialize( GosuDocArgs, true )

var writer = new GSDocHTMLWriter() {:Output = new File(GosuDocArgs.Out) }
writer.write()