package com.codesquad.baseball.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GamesController {

    private static final String gameDetailData = "{\n" +
            "    \"homeTeam\": {\n" +
            "        \"id\" : 1,\n" +
            "        \"teamName\": \"Captain\",\n" +
            "        \"players\": [\n" +
            "            {\n" +
            "                \"id\" : 1,\n" +
            "                \"name\" : \"최동원\",\n" +
            "                \"role\" : \"pitcher\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 2,\n" +
            "                \"name\" : \"치와와\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 3,\n" +
            "                \"name\" : \"벌꿀오소리\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "        \"id\" : 2,\n" +
            "        \"teamName\": \"MARVEL\",\n" +
            "        \"players\": [\n" +
            "            {\n" +
            "                \"id\" : 4,\n" +
            "                \"name\" : \"류현진\",\n" +
            "                \"role\" : \"pitcher\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 5,\n" +
            "                \"name\" : \"추신수\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 6,\n" +
            "                \"name\" : \"고양이\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"gameStatus\": {\n" +
            "        \"currentHitter\": 4,\n" +
            "        \"nextHitter\": 5,\n" +
            "        \"currentPitcher\": 1\n" +
            "    }\n" +
            "}";
    private static final String gamesJsonData = "{\n" +
            "    \"games\" : [\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"gameTitle\": \"GAME 1\",\n" +
            "            \"homeTeam\": {\n" +
            "                \"id\": 1,\n" +
            "                \"teamName\": \"Captin\",\n" +
            "                \"occupied\": false\n" +
            "            },\n" +
            "            \"awayTeam\": {\n" +
            "                \"id\": 2,\n" +
            "                \"teamName\": \"Marvel\",\n" +
            "                \"occupied\": true\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"gameTitle\": \"GAME 2\",\n" +
            "            \"homeTeam\": {\n" +
            "                \"id\": 3,\n" +
            "                \"teamName\": \"Twins\",\n" +
            "                \"occupied\": false\n" +
            "            },\n" +
            "            \"awayTeam\": {\n" +
            "                \"id\": 4,\n" +
            "                \"teamName\": \"Tigers\",\n" +
            "                \"occupied\": false\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"gameTitle\": \"GAME 3\",\n" +
            "            \"homeTeam\": {\n" +
            "                \"id\": 5,\n" +
            "                \"teamName\": \"Rockets\",\n" +
            "                \"occupied\": true\n" +
            "            },\n" +
            "            \"awayTeam\": {\n" +
            "                \"id\": 6,\n" +
            "                \"teamName\": \"Dodgers\",\n" +
            "                \"occupied\": false\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    private static final String pitchResult = "{\n" +
            "    \"isGameEnd\" : false,\n" +
            "    \"pitchResult\" : {\n" +
            "        \"pitcherId\" : 1,\n" +
            "        \"HitterId\" : 4,\n" +
            "        \"playType\" : \"HITS\",\n" +
            "        \"firstBase\" : -1,\n" +
            "        \"secondBase\" : -1,\n" +
            "        \"thirdBase\" : -1,\n" +
            "        \"backHome\" : [],\n" +
            "        \"pointsEarned\" : 0\n" +
            "    },\n" +
            "    \"homeTeam\": {\n" +
            "        \"id\" : 1,\n" +
            "        \"teamName\": \"Captain\",\n" +
            "        \"players\": [\n" +
            "            {\n" +
            "                \"id\" : 1,\n" +
            "                \"name\" : \"최동원\",\n" +
            "                \"role\" : \"pitcher\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 2,\n" +
            "                \"name\" : \"치와와\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 3,\n" +
            "                \"name\" : \"벌꿀오소리\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "        \"id\" : 2,\n" +
            "        \"teamName\": \"MARVEL\",\n" +
            "        \"players\": [\n" +
            "            {\n" +
            "                \"id\" : 4,\n" +
            "                \"name\" : \"류현진\",\n" +
            "                \"role\" : \"pitcher\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 5,\n" +
            "                \"name\" : \"추신수\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\" : 6,\n" +
            "                \"name\" : \"고양이\",\n" +
            "                \"role\" : \"hitter\",\n" +
            "                \"batOrder\" : 1,\n" +
            "                \"plateAppearances\" : 0,\n" +
            "                \"hitCount\" : 0,\n" +
            "                \"outCount\" : 0,\n" +
            "                \"avg\" : 0.000\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"gameStatus\": {\n" +
            "        \"inning\": 1,\n" +
            "        \"isTop\": true,\n" +
            "        \"strikeCount\": 0,\n" +
            "        \"ballCount\": 0,\n" +
            "        \"outCount\": 0,\n" +
            "        \"currentHitter\": 4,\n" +
            "        \"nextHitter\": 4,\n" +
            "        \"currentPitcher\": \"1\"\n" +
            "    },\n" +
            "    \"score\" : {\n" +
            "        \"homeTeamTotalScore\" : 0,\n" +
            "        \"awayTeamTotalScore\" : 0,\n" +
            "        \"innings\" : [\n" +
            "            {\n" +
            "                \"inning\" : 1,\n" +
            "                \"homeTeamScore\" : 0,\n" +
            "                \"awayTeamScore\" : 0\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";
    private static final String errorMessage = "mock api를 수행하는 과정에서 에러가 발생했습니다. nas한테 말해주세요";

    @CrossOrigin
    @GetMapping
    public Map games() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(gamesJsonData, Map.class);
        } catch (JsonProcessingException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("reason", errorMessage);
            return map;
        }
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public Map joinGame(@PathVariable("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(gameDetailData, Map.class);
        } catch (JsonProcessingException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("reason", errorMessage);
            return map;
        }
    }

    @CrossOrigin
    @PostMapping("/{id}/pitch")
    public Map doPitch(@PathVariable("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(pitchResult, Map.class);
        } catch (JsonProcessingException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("reason", errorMessage);
            return map;
        }
    }

}
