<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>hello world!</h1>
	<jsp:setProperty name="userInfo" property="*" />
	<!-- all -->
	You have entered below details:
	<br>
	<h6>(Option 2)</h6>
	Username : <input type="text" value="<%= session.getAttribute("email") %>" /><br>
	<!--   <servlet>
    <description></description>
    <display-name>LoginServlet</display-name>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>controller.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
  </servlet-mapping> -->
</body>	
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%-- <%@ taglib prefix="chart" uri="http://liferay.com/tld/chart"%>
<%@ page
	import="com.liferay.frontend.taglib.chart.model.percentage.donut.DonutChartConfig"%>
<%@ page
	import="com.liferay.frontend.taglib.chart.model.SingleValueColumn"%> --%>
<%-- 
<%
DonutChartConfig _donutChartConfig = new DonutChartConfig();

_donutChartConfig.addColumns(new SingleValueColumn("data1", 30), new SingleValueColumn("data2", 70));
%> --%>
<head>
<link rel="stylesheet" href="stylesheets/login.css" />
</head>
<t:dashboard>
	<jsp:attribute name="title">
      dashboard
    </jsp:attribute>
	<jsp:attribute name="header">
      <h1>Welcome</h1>  
    </jsp:attribute>

	<jsp:body>
	<div class="d-flex justify-content-center align-items-center">
    	Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit facilis nihil officia temporibus possimus earum odit quos nobis maiores libero eligendi, praesentium, vitae nam et. Excepturi aliquam unde quas voluptatem!
          Dolor quas soluta mollitia est tenetur fugit deserunt necessitatibus ratione, ducimus, aspernatur dignissimos eaque delectus alias doloremque consectetur minus numquam repellat vero beatae unde itaque ut a molestias aperiam. Odio.
          Doloribus assumenda quaerat recusandae cum eum pariatur unde voluptate veniam dolorem nisi! Perspiciatis accusamus cum recusandae quas illo repellat! In natus exercitationem dicta sint laborum doloremque suscipit perspiciatis corrupti. Placeat!
          Quidem illum consequatur accusantium magnam exercitationem rem ipsam a animi et iure vel, mollitia repellendus quaerat provident. Et nihil rem, incidunt eligendi veritatis iste adipisci unde. Voluptas est doloremque saepe.
          Voluptatem et dolores cumque nulla recusandae modi ducimus voluptates sed, nisi excepturi ullam dolorum voluptas dignissimos placeat vero eos consequatur inventore facere in! Consequatur vel quae veniam neque adipisci corrupti!
          Quibusdam asperiores dolore laborum dignissimos neque sint commodi, ex perferendis quae dolores dicta odit error expedita ipsum ullam officia, unde hic molestiae facilis explicabo consectetur maiores fugiat quo. Amet, architecto!
          Sapiente incidunt placeat consectetur expedita aliquam provident perspiciatis, quae exercitationem eos, accusamus, reiciendis est in laudantium esse quia cupiditate soluta quibusdam debitis voluptates. Sed assumenda consectetur incidunt quod eum sapiente?
          Ipsam odio debitis iusto deleniti quam eligendi officia mollitia adipisci! Officia, reiciendis architecto odio, blanditiis ratione ad esse earum alias numquam incidunt reprehenderit non nulla magni, temporibus expedita veritatis. Atque.
          Repudiandae vitae assumenda perspiciatis in debitis laborum quam hic quod numquam commodi fugit a cum aliquam deserunt, ex voluptas consectetur, cumque unde. Architecto commodi, quas doloremque suscipit similique atque. Error!
          Reiciendis cum voluptas saepe dignissimos libero porro ullam, maiores veniam quia. Corporis temporibus doloremque placeat provident nemo quis, sequi dolores incidunt ad odio quasi unde maxime officiis quaerat nulla ea!
          Deserunt molestias quae expedita, voluptate doloremque laboriosam assumenda minus amet earum culpa vitae reiciendis temporibus, qui laborum eum a dolore? Dolorem velit harum eos consectetur, rerum aut sequi quidem earum!
          Libero veniam, possimus, excepturi ab neque est culpa commodi consectetur perspiciatis eos magni eligendi, vero accusamus pariatur? Blanditiis rem, dolorum ea eos perferendis porro expedita dicta laborum nemo eveniet nostrum.
          Qui, hic rerum. Vel, quas repellendus? Facere necessitatibus, voluptas itaque excepturi fugiat, et delectus perferendis commodi aliquam ex doloremque sunt consequatur ullam. Quod expedita, numquam reiciendis repellendus aliquid quos fugit.
          Consectetur minima beatae, alias maiores fuga autem sequi excepturi non, architecto nemo dignissimos maxime cum natus, ullam commodi fugiat hic? Harum deleniti nam eligendi pariatur, quibusdam dolores saepe ullam facere!
          Eveniet, blanditiis molestias provident, modi, laborum nesciunt temporibus ex labore veritatis hic tempore illum deserunt perferendis enim nisi repudiandae quas nostrum ad voluptas. Optio corrupti modi, temporibus sed fuga quas.
          Consequatur delectus numquam laudantium porro alias atque, illo magni explicabo omnis quaerat reprehenderit unde sed enim ea voluptates minima repellendus molestias necessitatibus architecto aut officia ullam quae. Reprehenderit, hic sint.
          Nostrum perspiciatis tenetur blanditiis iure veniam quisquam odit? Quod, alias! Debitis, accusamus. Doloribus magni nihil dignissimos, veniam possimus sapiente beatae tempore ut ipsam, quia, qui voluptatem totam animi nobis rem.
          Quidem harum blanditiis inventore unde, sint dolor ipsam quo cumque ea laudantium maxime quaerat explicabo a, cupiditate nemo, perferendis doloribus atque libero nobis mollitia vero. Eum vitae in cumque debitis?
          Nobis minima, unde tempora cumque iusto ratione quibusdam dicta impedit ducimus sint repellat dolore optio dolor deleniti asperiores odio nostrum ipsam quasi! Totam nostrum suscipit a repellat praesentium architecto consequatur.
          Praesentium consectetur officia asperiores libero id maiores ipsa, temporibus pariatur beatae at nihil expedita itaque animi saepe iste. Temporibus fugiat, itaque dolores odio aspernatur aut veniam ipsam ab nobis consectetur?
          Consequatur, assumenda fugiat animi suscipit odio maiores expedita nobis? Aut commodi esse corporis doloremque tenetur, omnis earum facere molestias reiciendis, a architecto placeat iste asperiores, officia veniam quos quidem vel.
          Hic quia blanditiis eum distinctio sequi similique quam ex esse, totam sit sed, perspiciatis qui deleniti delectus eius est voluptatibus illum repellat velit maxime dolorum quisquam tempora aperiam perferendis. Ipsum!
          Nisi est numquam aliquid. Blanditiis sapiente porro dolorum doloremque quam debitis unde fuga laboriosam quasi. Quasi itaque similique ratione veritatis minus odio tempore corrupti ad officiis, inventore reprehenderit eaque iusto?
          Ipsam itaque quam voluptates nihil, atque commodi voluptas dolorem earum ab molestiae! Perferendis, accusamus, sint quo pariatur quibusdam veritatis totam cupiditate facere fugit voluptate ipsam blanditiis nihil, similique hic illo.
          Reprehenderit quam consectetur quidem eveniet rem assumenda at sunt, quibusdam officia? Facere harum alias rem excepturi laudantium aspernatur, ipsum, temporibus sed facilis a nihil quod veniam nam laboriosam sequi accusamus?
          Consequatur, atque debitis quaerat recusandae quia minus porro amet pariatur officiis, dolor sint veniam perferendis harum maxime, ipsum qui obcaecati placeat unde nesciunt fugit necessitatibus. Explicabo deserunt omnis atque sit.
          Rerum, sunt quis. Assumenda at veniam cupiditate voluptas corporis, fugiat porro enim officiis et totam ex eveniet debitis qui quod, illum quae sequi quaerat nobis iste dolorum? Eveniet, porro culpa?
          Veritatis deserunt vero, numquam fugit praesentium dolorum quo doloremque placeat atque aliquam illo consectetur magni magnam odit voluptatibus sapiente dolore cum obcaecati consequatur, impedit ut laudantium non id quaerat. Ex.
          Ducimus magni nulla debitis id, labore ut doloremque voluptas deleniti eius dolor. Veritatis expedita necessitatibus voluptatem eligendi saepe quas, harum consequuntur minima blanditiis, accusantium similique dolore totam, illo quaerat quis!
          Error quis sint tempora, aperiam distinctio sapiente eveniet nesciunt nemo nobis, at soluta aliquam. Explicabo similique sequi aperiam beatae eveniet quos! Debitis, quas earum cupiditate illum eligendi modi rem hic.
          Facilis, non voluptates. Nostrum hic voluptas quam pariatur facere magni eaque ratione ut eum. Doloremque enim, amet veniam ea aliquid cupiditate tempore perspiciatis, similique distinctio soluta quam suscipit velit incidunt.
          Quia ex possimus, mollitia sit voluptatibus eaque autem provident recusandae nemo nihil sequi illum facere debitis doloremque excepturi magni beatae quae! Hic animi eveniet temporibus unde similique dicta? Maxime, consequatur.
          Ut totam at neque deleniti officia illum voluptates, asperiores soluta aliquid eligendi voluptatum culpa ducimus sint mollitia dolorem, distinctio vitae amet architecto doloribus reprehenderit sequi nobis assumenda maiores tempore! Nam?
          Aperiam, debitis molestiae repellat incidunt quisquam minus blanditiis eius, cumque provident officia voluptatum ut explicabo quas? Quasi blanditiis, aliquam eligendi dolor dignissimos laboriosam exercitationem est deleniti. Quae dolor suscipit tempore.
          Consequuntur voluptatibus voluptate voluptatem illo deserunt autem consectetur. Dolorem expedita velit vitae adipisci odit iusto quia corrupti obcaecati ipsa! Maxime dolorum incidunt autem quae nobis perspiciatis alias distinctio ipsum quidem?
          Repellendus nesciunt culpa ab! Impedit quas harum velit repellat reiciendis quo autem voluptatem hic, nobis, necessitatibus fuga libero? Atque eveniet voluptatum totam dolore perspiciatis commodi natus? Minus aut accusamus consequuntur.
          Eaque cupiditate necessitatibus obcaecati et repellendus minima excepturi! Animi maxime eaque labore, consectetur minus et explicabo suscipit sint, officia est harum sapiente reiciendis consequatur autem. Aspernatur ipsam exercitationem maiores voluptate!
          Omnis nemo optio mollitia porro excepturi, vel suscipit ea molestiae ipsum doloribus sequi ut inventore nostrum nobis vero culpa ipsam, recusandae officia quisquam libero cumque quia dolorem. Aperiam, quos nihil?
          Quam quia maiores cum dolor animi consequatur culpa ipsa quibusdam dolorem provident corrupti eum, harum quidem omnis repudiandae dicta repellat molestias saepe ex dolore aliquid? Error distinctio voluptatem alias neque!
          Quasi minima, veritatis, ipsam repellat nobis corrupti facilis ratione voluptatibus totam vitae pariatur iusto deserunt quod incidunt quidem soluta quaerat? Veniam, iure! Optio rem alias velit odit iusto sequi placeat.
          Possimus et esse iure vero ut ea quod ducimus corporis, eaque voluptates sit tenetur, reiciendis iusto incidunt distinctio nobis hic porro odio? Minima eos eius culpa corrupti reiciendis reprehenderit cum.
          Veritatis quae provident alias neque tenetur quisquam totam accusantium beatae esse ab deserunt non vel, at maiores aliquam? Fugiat, quidem atque? Quibusdam labore, libero officia earum et similique unde inventore?
          Ratione veritatis eum et. Blanditiis, ea culpa temporibus nesciunt delectus beatae. Tenetur sed neque sint a voluptate ipsa dignissimos totam quibusdam, aspernatur debitis exercitationem. Dignissimos eaque nulla deleniti suscipit? Ipsum?
          Enim corporis dicta ex officia vel, corrupti veniam exercitationem non, rerum aut nihil minima odio perspiciatis velit dolor dolorum cum! Quibusdam mollitia voluptas voluptate temporibus perferendis non consequatur quasi quae.
          Molestiae nemo, error ab sapiente impedit architecto? Eos omnis magnam laborum mollitia dicta. Ea consectetur porro eligendi sunt reprehenderit perferendis, beatae dolorum id mollitia inventore sapiente aperiam iusto quisquam incidunt?
          Quia reiciendis sapiente ipsam amet blanditiis atque tempore. Minima aliquam corrupti consequuntur reiciendis laborum consectetur, et maiores eos iste soluta. Animi odio culpa sit autem harum praesentium eos tempore fuga?
          Quo, modi similique tempore reprehenderit sint totam inventore provident veniam officiis neque quibusdam laborum necessitatibus repellendus soluta cum voluptas mollitia dolore iure perferendis ipsa culpa nemo est vero ut. At.
          Quasi, nesciunt aliquam iste corrupti voluptate nam minus doloribus iusto facilis ad ducimus quod magni, dolores accusamus repellendus sint aspernatur, magnam amet pariatur molestiae qui consectetur mollitia. Dignissimos, dolorem pariatur.
          Nisi maxime ipsa quasi repellat unde exercitationem at vitae, veritatis, et beatae ratione aliquid temporibus molestias possimus nobis? Odit enim aut dolores quis. Distinctio laudantium, tenetur necessitatibus ad unde a.
          Quasi, et nobis distinctio corporis accusantium recusandae esse. Itaque exercitationem praesentium sed. Maiores ducimus consectetur omnis voluptas. Omnis, delectus ut dolorem minus earum corporis sint ipsam, necessitatibus, quae sed repudiandae?
     </div>
    </jsp:body>
</t:dashboard>