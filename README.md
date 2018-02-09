# linux 公社资源抓取工具

## [linux公社地址](http://linux.linuxidc.com/)

### 本爬虫使用组合设计模式那边离目录树

## 资源

> - [sql文件](/src/main/resources/create.sql)
> - [文件目录树](/src/main/resources/dir.md)

### 部分示例
#### sql
```sql
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('Linux Mint 16 Cinnamon 用户指南官方中文版PDF.7z', 'http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTbE6tfKwc8vNtTCLzIyyNUvTGludXggTWludCAxNiBDaW5uYW1vbiDTw7un1rjEz7nZt73W0M7EsOZQREYvTGludXglMjBNaW50JTIwMTYlMjBDaW5uYW1vbiUyMCVEMyVDMyVCQiVBNyVENiVCOCVDNCVDRiVCOSVEOSVCNyVCRCVENiVEMCVDRSVDNCVCMCVFNlBERi43eg==', '文件', './linuxfiles/2016年资料/6月/22日/Linux Mint 16 Cinnamon 用户指南官方中文版PDF/Linux Mint 16 Cinnamon 用户指南官方中文版PDF.7z', '2.36 MB', '2016-06-22 00:00:00');
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('1日', 'http://linux.linuxidc.com/index.php?folder=MjAxNsTq18rBzy821MIvMcjV', '文件夹', '2016年资料/6月/1日', '-', '2017-01-13 19:01:46');
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('Mac OS X 高清壁纸 5120 x 2880', 'http://linux.linuxidc.com/index.php?folder=MjAxNsTq18rBzy821MIvMcjVL01hYyBPUyBYILjfx+Wx2ta9IDUxMjAgeCAyODgw', '文件夹', '2016年资料/6月/1日/Mac OS X 高清壁纸 5120 x 2880', '-', '2017-01-13 19:01:46');
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('MacBuntu.rar', 'http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTbE6tfKwc8vNtTCLzHI1S9NYWMgT1MgWCC438flsdrWvSA1MTIwIHggMjg4MC9NYWNCdW50dS5yYXI=', '文件', './linuxfiles/2016年资料/6月/1日/Mac OS X 高清壁纸 5120 x 2880/MacBuntu.rar', '3.78 MB', '2016-06-01 00:00:00');
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('Oracle高级SQL培训与讲解PDF', 'http://linux.linuxidc.com/index.php?folder=MjAxNsTq18rBzy821MIvMcjVL09yYWNsZbjfvLZTUUzF4NG10+u9sr3iUERG', '文件夹', '2016年资料/6月/1日/Oracle高级SQL培训与讲解PDF', '-', '2017-01-13 19:01:51');
INSERT INTO linuxidc.file (name, url, type, path, size, uploadtime) VALUES ('Oracle高级SQL培训与讲解.rar', 'http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTbE6tfKwc8vNtTCLzHI1S9PcmFjbGW437y2U1FMxeDRtdPrvbK94lBERi9PcmFjbGUlQjglREYlQkMlQjZTUUwlQzUlRTAlRDElQjUlRDMlRUIlQkQlQjIlQkQlRTIucmFy', '文件', './linuxfiles/2016年资料/6月/1日/Oracle高级SQL培训与讲解PDF/Oracle高级SQL培训与讲解.rar', '2.09 MB', '2016-06-01 00:00:00');
```
### 树
```
\       http://linux.linuxidc.com/      null      null

      \ 2012年资料      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzw==      -      2017-01-13 17:55:34

            \ 7月      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MI=      -      2017-01-13 18:18:35

                  \ 30日      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1Q==      -      2017-01-13 18:21:56

                        \ Wunderlist for Ubuntu 发布      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1S9XdW5kZXJsaXN0IGZvciBVYnVudHUgt6KyvA==      -      2017-01-13 18:22:13

                                    │── 教程说明见这里.txt      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvV3VuZGVybGlzdCBmb3IgVWJ1bnR1ILeisrwvJUJEJUNDJUIzJUNDJUNCJUI1JUMzJUY3JUJDJUZCJUQ1JUUyJUMwJUVGLnR4dA==      0.1 KB      2012-07-30 00:00:00

                                    │── wunderlist-fogapp-0.2.tar.gz      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvV3VuZGVybGlzdCBmb3IgVWJ1bnR1ILeisrwvd3VuZGVybGlzdC1mb2dhcHAtMC4yLnRhci5neg==      29.4 KB      2012-07-30 00:00:00

                        \ Xfce 风格的浅棕色 GDM 主题      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1S9YZmNlILfnuPG1xMez19jJqyBHRE0g1vfM4g==      -      2017-01-13 18:22:15

                                    │── xfce simple-brown mdm.zip      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvWGZjZSC357jxtcTHs9fYyasgR0RNINb3zOIveGZjZSUyMHNpbXBsZS1icm93biUyMG1kbS56aXA=      17.9 KB      2012-07-30 00:00:00

                                    │── 教程说明见这里.txt      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvWGZjZSC357jxtcTHs9fYyasgR0RNINb3zOIvJUJEJUNDJUIzJUNDJUNCJUI1JUMzJUY3JUJDJUZCJUQ1JUUyJUMwJUVGLnR4dA==      0.1 KB      2012-07-30 00:00:00

                        \ 《MongoDB 权威指南》(MongoDB The Definitive Guide)英文文字版[PDF]      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1S+htk1vbmdvREIgyKjN/ta4xM+htyhNb25nb0RCIFRoZSBEZWZpbml0aXZlIEd1aWRlKdOizsTOxNfWsOZbUERGXQ==      -      2017-01-13 18:21:56

                                    │── [MongoDB权威指南].(MongoDB：The.Definitive.Guide).K.Chodorow&M.Dirolf.文字版.rar      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvobZNb25nb0RCIMiozf7WuMTPobcoTW9uZ29EQiBUaGUgRGVmaW5pdGl2ZSBHdWlkZSnTos7EzsTX1rDmW1BERl0vJTVCTW9uZ29EQiVDOCVBOCVDRCVGRSVENiVCOCVDNCVDRiU1RC4lMjhNb25nb0RCJUEzJUJBVGhlLkRlZmluaXRpdmUuR3VpZGUlMjkuSy5DaG9kb3JvdyUyNk0uRGlyb2xmLiVDRSVDNCVENyVENiVCMCVFNi5yYXI=      3.21 MB      2012-07-30 00:00:00

                        \ Android编程之Bitmap图片压缩大小      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1S9BbmRyb2lkseCzzNauQml0bWFwzbzGrNG5y/W089Ch      -      2017-01-13 18:22:00

                                    │── TestCompressBitmap.rar      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvQW5kcm9pZLHgs8zWrkJpdG1hcM28xqzRucv1tPPQoS9UZXN0Q29tcHJlc3NCaXRtYXAucmFy      29.8 KB      2012-07-30 00:00:00

                                    │── 教程说明见这里.txt      http://linux.linuxidc.com/linuxconf/download.php?file=Li9saW51eGZpbGVzLzIwMTLE6tfKwc8vN9TCLzMwyNUvQW5kcm9pZLHgs8zWrkJpdG1hcM28xqzRucv1tPPQoS8lQkQlQ0MlQjMlQ0MlQ0IlQjUlQzMlRjclQkMlRkIlRDUlRTIlQzAlRUYudHh0      0.1 KB      2012-07-30 00:00:00

                        \ jQuery时间控件Datepicker汉化版使用详解      http://linux.linuxidc.com/index.php?folder=MjAxMsTq18rBzy831MIvMzDI1S9qUXVlcnnKsbzkv9i8/kRhdGVwaWNrZXK6uruvsObKudPDz+q94g==      -      2017-01-13 18:22:01

```

