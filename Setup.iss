; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "Education System"
#define MyAppVersion "1.0"
#define MyAppPublisher "FPT Polytechnic"
#define MyAppURL "https://caodang.fpt.edu.vn/"
#define MyAppExeName "EduSys.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{D09736AB-B101-4C35-83ED-BF957200535B}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\EduSys
DisableProgramGroupPage=yes
OutputDir=C:\Users\Admin\OneDrive\TaiLieu
OutputBaseFilename=setup
SetupIconFile=C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\favicon.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked; OnlyBelowVersion: 0,6.1

[Files]
Source: "C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\dist\EduSys.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\dist\db\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\dist\lib\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\dist\logos\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Users\Admin\OneDrive\M�y t�nh\SOF204_DA_MAU\Lab_SOF204\ASS_SOF2041\dist\ASS_SOF2041.jar"; DestDir: "{app}"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: quicklaunchicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

