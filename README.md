
# [jjdxm_update][project] #

### Copyright notice ###

我在网上写的文章、项目都可以转载，但请注明出处，这是我唯一的要求。当然纯我个人原创的成果被转载了，不注明出处也是没有关系的，但是由我转载或者借鉴了别人的成果的请注明他人的出处，算是对前辈们的一种尊重吧！

虽然我支持写禁止转载的作者，这是他们的成果，他们有这个权利，但我不觉得强行扭转用户习惯会有一个很好的结果。纯属个人的观点，没有特别的意思。可能我是一个版权意识很差的人吧，所以以前用了前辈们的文章、项目有很多都没有注明出处，实在是抱歉！有想起或看到的我都会逐一补回去。

从一开始，就没指望从我写的文章、项目上获得什么回报，一方面是为了自己以后能够快速的回忆起曾经做过的事情，避免重复造轮子做无意义的事，另一方面是为了锻炼下写文档、文字组织的能力和经验。如果在方便自己的同时，对你们也有很大帮助，自然是求之不得的事了。要是有人转载或使用了我的东西觉得有帮助想要打赏给我，多少都行哈，心里却很开心，被人认可总归是件令人愉悦的事情。

站在了前辈们的肩膀上，才能走得更远视野更广。前辈们写的文章、项目给我带来了很多知识和帮助，我没有理由不去努力，没有理由不让自己成长的更好。写出好的东西于人于己都是好的，但是由于本人自身视野和能力水平有限，错误或者不好的望多多指点交流。

项目中如有不同程度的参考借鉴前辈们的文章、项目会在下面注明出处的，纯属为了个人以后开发工作或者文档能力的方便。如有侵犯到您的合法权益，对您造成了困惑，请联系协商解决，望多多谅解哈！若您也有共同的兴趣交流技术上的问题加入交流群QQ： 548545202

感谢作者[shelwee][author]，[yjfnypeu][author1]，本项目是基于[UpdateHelper][url]和[UpdatePlugin][url1]项目

## Introduction ##


应用内更新，实现类似友盟自动更新sdk的更新模式，用户使用前只需要配置自己的服务器更新检查接口即可（必须接口），也可以拓展加入一个接口作为在线参数配置来实现（可选接口）可实现以下四种种方式更新和是否强制更新组合使用，支持get、post方式请求网络，默认是使用get方式

## 更新检查 ##
### 1.手动更新：手动检测更新（所有网络类型环境检测并提示主要用于点击检测使用）  ###
### 2.自动更新：自动检测更新（所有网络类型环境检测并提示） ###
### 3.仅WiFi自动检测更新（只有WiFi网络类型环境检测并提示） ###
### 4.静默更新：仅WiFi自动检测下载（只有WiFi网络类型环境检测、下载完才提示） ###
## 强制更新 ##
两种方式，一是在更新检测返回后，直接设置update.setForce(true);二是配合在线参数使用，通过在线参数返回设置UpdateHelper.getInstance().setForced(true);结合以上几种方式组合使用，主要使用场景是当上一个版本的APP有重大bug或漏洞时，修改在线参数统一控制所有的APP用户，使得之前的所有版本必须要升级才能正常使用。主要原理：服务器上修改参数的数值，APP端获取后进行判断，如果为强制更新，则在打开应用是提示有新版APP更新，更新完成才能使用，提示框不消失，用户如果选择不更新则退出应用。


## Features ##
### 1.更新数据接口用户可自定义 ###
### 2.在线参数接口用户可自定义 ###
### 3.参数结构返回可以让用户自定义解析 ###
## Screenshots ##

<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon01.gif" width="300">
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon02.gif" width="300">
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon01.png" width="300"> 
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon02.png" width="300"> 
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon03.png" width="300">
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon04.png" width="300">
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon05.png" width="300">
<img src="https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon06.png" width="300">

## Download ##

[demo apk下载][downapk]

Download or grab via Maven:

	<dependency>
	  <groupId>com.dou361.update</groupId>
	  <artifactId>jjdxm-update</artifactId>
	  <version>x.x.x</version>
	</dependency>

or Gradle:

	compile 'com.dou361.update:jjdxm-update:x.x.x'

历史版本：

    compile 'com.dou361.update:jjdxm-update:1.0.7'
	compile 'com.dou361.update:jjdxm-update:1.0.6'
	compile 'com.dou361.update:jjdxm-update:1.0.5'
	compile 'com.dou361.update:jjdxm-update:1.0.4'
	compile 'com.dou361.update:jjdxm-update:1.0.3'
	compile 'com.dou361.update:jjdxm-update:1.0.2'
	compile 'com.dou361.update:jjdxm-update:1.0.1'
	compile 'com.dou361.update:jjdxm-update:1.0.0'


jjdxm-update requires at minimum Java 9 or Android 2.3.

[架包的打包引用以及冲突解决][jaraar]

## Proguard ##

类库中使用consumerProguardFiles属性，它指定了编译时，库自动引入的混淆规则。也就是说应用打包时候会自动的寻找库里的混淆文件，不需要手工配置了。

[AndroidStudio代码混淆注意的问题][minify]

## Get Started ##

step1

需要申请的一些权限已经集成到类库中了,引入依赖，如果主程序项目中有重复的类库，可以用打开注释来移除重复依赖。

    compile ('com.dou361.update:jjdxm-update:1.0.7'){
//        exclude group: 'com.android.support', module: 'support-v4'
//        exclude group: 'com.dou361.download', module: 'jjdxm-download'
    }

请参考 wiki 文档：[开发指南][wikiurl]

- 1 [概述](https://github.com/jjdxmashl/jjdxm_update/wiki#1)
	- 1.1 [功能以及版本](https://github.com/jjdxmashl/jjdxm_update/wiki#1.1)
	- 1.2 [特性](https://github.com/jjdxmashl/jjdxm_update/wiki#1.2)
- 2 [阅读对象](https://github.com/jjdxmashl/jjdxm_update/wiki#2)
- 3 [开发准备](https://github.com/jjdxmashl/jjdxm_update/wiki#3)
	- 3.1 [设备以及系统](https://github.com/jjdxmashl/jjdxm_update/wiki#3.1)
	- 3.2 [混淆](https://github.com/jjdxmashl/jjdxm_update/wiki#3.3)
	- 3.3 [版本升级须知](https://github.com/jjdxmashl/jjdxm_update/wiki#3.3)
- 4 [快速开始](https://github.com/jjdxmashl/jjdxm_update/wiki/4-%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B#4)
	- 4.1 [配置开发环境](https://github.com/jjdxmashl/jjdxm_update/wiki/4-%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B#4.1)
	- 4.2 [SDK 集成](https://github.com/jjdxmashl/jjdxm_update/wiki/4-%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B#4.2)
- 5 [功能使用](https://github.com/jjdxmashl/jjdxm_update/wiki/5-%E5%8A%9F%E8%83%BD%E4%BD%BF%E7%94%A8#5)
	- 5.1 [播放参数配置](https://github.com/jjdxmashl/jjdxm_update/wiki/5-%E5%8A%9F%E8%83%BD%E4%BD%BF%E7%94%A8#5.1)
	- 5.2 [播放状态回调](https://github.com/jjdxmashl/jjdxm_update/wiki/5-%E5%8A%9F%E8%83%BD%E4%BD%BF%E7%94%A8#5.2)
	- 5.3 [连接状态处理](https://github.com/jjdxmashl/jjdxm_update/wiki/5-%E5%8A%9F%E8%83%BD%E4%BD%BF%E7%94%A8#5.3)
	- 5.4 [播放器声音调节](https://github.com/jjdxmashl/jjdxm_update/wiki/5-%E5%8A%9F%E8%83%BD%E4%BD%BF%E7%94%A8#5.4)
- 6 [知识补充与建议](https://github.com/jjdxmashl/jjdxm_update/wiki/6-%E7%9F%A5%E8%AF%86%E7%9A%84%E8%A1%A5%E5%85%85%E4%B8%8E%E5%BB%BA%E8%AE%AE#6)
- 7 [历史记录](https://github.com/jjdxmashl/jjdxm_update/wiki/8-%E5%8E%86%E5%8F%B2%E8%AE%B0%E5%BD%95#8)


## ChangeLog ##

2016.12.06 1.0.7版本打包，添加混淆规则，移除反射自动和手动检测分开不同activity调用

2016.10.13 添加自定义状态栏、自定义强制更新弹出框、网络分离使用自己的网络框架进行联网；修复状态栏不显示应用名称，autowifiupdate中，在流量情况下也会提示更新界面，进入安装界面再删除安装包后，点击安装提示的解析错误等

2016.09.23 修复安装包被删除后还继续提示安装，用户取消更新监听（注系统安装界面后的取消不进行监听）

2016.09.04 修复只能通过post方式请求接口。添加在线参数和强制更新功能，添加自定义弹出布局的样式

2016.07.29 修复07.28打包post请求方式造成的get请求需要传params集合问题。
2016.07.28修复通知栏暂停取消和进度显示问题，增加post请求方式获取数据。

2016.06.20修复通知栏提示报错问题，修改v7.jar依赖方式，让用户自己去配置版本。

2016.06.17当前版本只有四种更新方式，可以支持断点续传。

## About Author ##

#### 个人网站:[http://www.dou361.com][web] ####
#### GitHub:[jjdxmashl][github] ####
#### QQ:316988670 ####
#### 交流QQ群:548545202 ####


## License ##

    Copyright (C) dou361, The Framework Open Source Project
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
     	http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## (Frequently Asked Questions)FAQ ##
## Bugs Report and Help ##

If you find any bug when using project, please report [here][issues]. Thanks for helping us building a better one.




[web]:http://www.dou361.com
[github]:https://github.com/jjdxmashl/
[project]:https://github.com/jjdxmashl/jjdxm_update/
[issues]:https://github.com/jjdxmashl/jjdxm_update/issues/new
[wikiurl]:https://github.com/jjdxmashl/jjdxm_update/wiki
[downapk]:https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/apk/app-debug.apk
[lastaar]:https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/release/jjdxm-update-1.0.3.aar
[lastjar]:https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/release/jjdxm-update-1.0.3.jar
[icon01]:https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon01.png
[icon02]:https://raw.githubusercontent.com/jjdxmashl/jjdxm_update/master/screenshots/icon02.png
[jaraar]:https://github.com/jjdxmashl/jjdxm_ecodingprocess/blob/master/架包的打包引用以及冲突解决.md
[minify]:https://github.com/jjdxmashl/jjdxm_ecodingprocess/blob/master/AndroidStudio代码混淆注意的问题.md
[author]:https://github.com/shelwee
[url]:https://github.com/shelwee/UpdateHelper
[author1]:https://github.com/yjfnypeu
[url1]:https://github.com/yjfnypeu/UpdatePlugin
