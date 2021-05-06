package com.codesquad.baseball.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/games")
public class GamesController {

    private static final String gameDetailData = "{\"occupied\": false,\n" +
            "        \"awayTeam\": {\n" +
            "            \"teamName\": \"MARVEL\",\n" +
            "            \"players\": [\n" +
            "                \"player1\",\n" +
            "                \"player2\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"homeTeam\": {\n" +
            "            \"teamName\": \"Captain\",\n" +
            "            \"players\": [\n" +
            "                \"player1\",\n" +
            "                \"player2\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"gameStatus\": {\n" +
            "            \"strikeCount\": 0,\n" +
            "            \"ballCount\": 0,\n" +
            "            \"outCount\": 0,\n" +
            "            \"homeTeamScore\": 0,\n" +
            "            \"awayTeamScore\": 0,\n" +
            "            \"currentHitter\": \"류현진\",\n" +
            "            \"currentPitcher\": \"최동원\",\n" +
            "            \"inning\": 1,\n" +
            "            \"isTop\": true\n" +
            "        }}";
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
    @GetMapping("/{id}")
    public Map detailGame(@PathVariable("id") int id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(gameDetailData, Map.class);
        } catch (JsonProcessingException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("reason", errorMessage);
            return map;
        }
    }
}
