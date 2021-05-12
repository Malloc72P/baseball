import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { theme, Span } from '../Style/Theme';
import Scroll from '../Style/Scroll';
import { useGameState } from '../GameContext';

const GameLog = () => {
	const { state } = useGameState();
	const [logData, setLogData] = useState([]);

	if (state.pitchResult) {
		console.log(state.gameStatusDTO);
	}

	const SingleLog = () => {};

	useEffect(() => {
		if (state.pitchResult) {
			console.log(
				state.gameStatusDTO.currentHitter,
				state.pitchResult.playType,
				`S${state.gameStatusDTO.strikeCount} B${state.gameStatusDTO.ballCount}`,
			);
		}
	}, [logData]);

	return (
		<GameLogScroll>
			<PlayerWrapper>
				<Player now={true}>7번 타자 류진</Player>
				<LogWrapper>
					<Number>&#9316;</Number>
					<Log>스트라이크</Log>
					<AccLog>S2 B3</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9315;</Number>
					<Log>볼</Log>
					<AccLog>S1 B3</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9314;</Number>
					<Log>볼</Log>
					<AccLog>S1 B2</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9313;</Number>
					<Log>볼</Log>
					<AccLog>S1 B1</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9312;</Number>
					<Log> 스트라이크</Log>
					<AccLog>S1 B0</AccLog>
				</LogWrapper>
			</PlayerWrapper>
		</GameLogScroll>
	);
};
const GameLogScroll = styled(Scroll)``;

const PlayerWrapper = styled.div`
	padding-left: 20px;
`;
const LogWrapper = styled.div`
	width: fit-content;
	padding-top: 10px;
	display: grid;
	grid-template-columns: 20px 130px 100px;
`;
const Player = styled.div`
	margin: 15px 0;
	font-size: ${theme.fontSize.medium};
	font-weight: ${theme.fontWeight.medium};
	color: ${(props) =>
		props.now ? theme.colors.red_log : theme.colors.skyblue_log};
`;
const Result = styled(Span)`
	width: 150px;
	color: ${theme.colors.blue_log};
`;
const Number = styled(Span)`
	color: ${theme.colors.white};
`;
const Log = styled(Span)`
	color: ${theme.colors.white};
`;
const AccLog = styled(Span)`
	color: ${theme.colors.grey};
`;

export default GameLog;
