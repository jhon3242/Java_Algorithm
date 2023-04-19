package tmp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class main {
	public static void main(String[] args) throws ParseException {

		String a = "그라가스, 마오카이, 말파이트, 세주아니, 뽀삐, 사이온, 쉔, 스카너, 신지드, 오른, 자크, 초가스, 크산테, 탐 켄치, 가렌, 그레이브즈, 갱플랭크[A], 그웬, 나르, 나서스, 다리우스, 럼블, 레넥톤, 리븐, 릴리아, 모데카이저, 문도 박사, 볼리베어, 세트, 아트록스, 오공, 올라프, 요릭, 우르곳, 워윅, 이렐리아, 일라오이, 잭스, 카밀, 클레드, 트린다미어, 피오라, 판테온, 블라디미르, 사일러스, 라이즈, 말자하, 빅토르, 스웨인, 카르마, 카시오페아, 케넨, 하이머딩거, 루시안, 베인, 아크샨, 제이스[A], 케일[19], 칼리스타, 퀸, 티모, 렝가, 아칼리, 요네, 야스오, 리 신, 누누와 윌럼프, 세주아니, 아무무, 아이번, 자크, 렉사이, 렝가, 리 신, 신 짜오, 엘리스, 우디르(야생 발톱), 워윅, 그라가스, 녹턴, 람머스, 바이, 볼리베어, 뽀삐, 사일러스, 스카너, 오공, 우디르(날개 돋친 폭풍), 자르반 4세, 잭스, 제드, 카밀, 트런들, 탈리야, 헤카림, 다이애나, 럼블, 릴리아, 마스터 이, 마오카이, 모데카이저, 문도 박사, 벨베스, 비에고, 쉬바나, 에코, 탈론, 이블린, 카서스[13], 카직스, 케인[14], 피들스틱, 그레이브즈, 니달리, 샤코, 킨드레드, 갈리오, 아우렐리온 솔, 트위스티드 페이트, 라이즈, 탈리야, 다이애나, 럼블, 말파이트, 모데카이저, 블라디미르, 사일러스, 스웨인, 케일[8], 카시오페아, 애니비아, 신지드, 그라가스, 럼블, 초가스, 럭스, 벨코즈, 제라스, 빅토르, 하이머딩거, 카르마, 오리아나, 직스, 코르키, 니코, 르블랑, 리산드라, 말자하, 모르가나[9], 베이가, 벡스, 벨코즈, 브랜드, 신드라, 아리, 아칼리, 애니, 에코, 조이, 질리언, 카사딘, 카타리나, 피즈, 아지르, 루시안, 베인, 사미라, 카이사, 칼리스타, 그레이브즈,드레이븐, 바루스, 시비르, 아펠리오스, 자야, 제리, 징크스, 코그모, 트리스타나, 트위치, ";
		String[] split = a.split(", ");
		List<String> collect = Arrays.stream(split).distinct().collect(Collectors.toList());
		for (int i = 0; i < 5; i++) {
			int index = (int) (Math.random() * 12) + 1;
			String name;
			String s = collect.get(index);
			if (i == 0){
				name = "김종현";
			} else if (i == 1) {
				name = "김현태";
			} else if (i == 2) {
				name = "최원준";
			} else if (i == 3) {
				name = "한윤상";
			} else if (i == 4) {
				name = "백경민";
			} else {
				name = "null";
			}
			System.out.println(name + " = " + s);
			collect.remove(index);
		}

	}
}
