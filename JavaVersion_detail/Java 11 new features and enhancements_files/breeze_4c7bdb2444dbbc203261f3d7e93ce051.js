/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/SyntaxHighlighter
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/SyntaxHighlighter/donate.html
 *
 * @version
 * 3.0.83 (Wed, 16 Apr 2014 03:56:09 GMT)
 *
 * @copyright
 * Copyright (C) 2004-2013 Alex Gorbatchev.
 *
 * @license
 * Dual licensed under the MIT and GPL licenses.
 */
;(function(){SyntaxHighlighter=SyntaxHighlighter||(typeof require!=='undefined'?require('shCore').SyntaxHighlighter:null);function Brush(){var keywords='abstract assert boolean break byte case catch char class const '+'continue default do double else enum extends '+'false final finally float for goto if implements import '+'instanceof int interface long native new null '+'package private protected public return '+'short static strictfp super switch synchronized this throw throws true '+'transient try void volatile while';this.regexList=[{regex:SyntaxHighlighter.regexLib.singleLineCComments,css:'comments'},{regex:/\/\*([^\*][\s\S]*?)?\*\//gm,css:'comments'},{regex:/\/\*(?!\*\/)\*[\s\S]*?\*\//gm,css:'preprocessor'},{regex:SyntaxHighlighter.regexLib.doubleQuotedString,css:'string'},{regex:SyntaxHighlighter.regexLib.singleQuotedString,css:'string'},{regex:/\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,css:'value'},{regex:/(?!\@interface\b)\@[\$\w]+\b/g,css:'color1'},{regex:/\@interface\b/g,css:'color2'},{regex:new RegExp(this.getKeywords(keywords),'gm'),css:'keyword'}];this.forHtmlScript({left:/(&lt;|<)%[@!=]?/g,right:/%(&gt;|>)/g})};Brush.prototype=new SyntaxHighlighter.Highlighter();Brush.aliases=['java'];SyntaxHighlighter.brushes.Java=Brush;typeof(exports)!='undefined'?exports.Brush=Brush:null})()