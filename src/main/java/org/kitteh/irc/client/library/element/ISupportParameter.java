/*
 * * Copyright (C) 2013-2019 Matt Baxter https://kitteh.org
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.kitteh.irc.client.library.element;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.kitteh.irc.client.library.element.mode.ChannelMode;
import org.kitteh.irc.client.library.element.mode.ChannelUserMode;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Represents an ISUPPORT parameter sent by the server.
 */
public interface ISupportParameter extends ClientLinked {
    /**
     * Represents a parameter which always has an integer value.
     */
    interface IntegerParameter extends ISupportParameter {
        /**
         * Gets the value of this parameter.
         *
         * @return the processed value
         */
        int getInteger();
    }

    /**
     * Represents a parameter which maybe has an integer value.
     */
    interface OptionalIntegerParameter extends ISupportParameter {
        /**
         * Gets the value of this parameter.
         *
         * @return the processed value
         */
        OptionalInt getInteger();
    }

    /**
     * Represents the length limit of an away reason.
     */
    interface AwayLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "AWAYLEN";
    }

    /**
     * Represents the {@link org.kitteh.irc.client.library.feature.CaseMapping}
     * supported by the server.
     */
    interface CaseMapping extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "CASEMAPPING";

        /**
         * Gets the casemapping specified.
         *
         * @return casemapping
         */
        org.kitteh.irc.client.library.feature.@NonNull CaseMapping getCaseMapping();
    }

    /**
     * Represents the length limit of channels.
     */
    interface ChannelLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "CHANNELLEN";
    }

    /**
     * Represents the join limit of channels by prefix.
     */
    interface ChanLimit extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "CHANLIMIT";

        /**
         * Gets the channel limits.
         *
         * @return limits by prefix
         */
        @NonNull Map<Character, Integer> getLimits();
    }

    /**
     * Represents the channel modes supported.
     */
    interface ChanModes extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "CHANMODES";

        /**
         * Gets the channel modes.
         *
         * @return channel modes
         */
        @NonNull List<ChannelMode> getModes();
    }

    /**
     * Represents the channel prefixes supported.
     */
    interface ChanTypes extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "CHANTYPES";

        /**
         * Gets the channel types.
         *
         * @return supported prefixes
         */
        @NonNull List<Character> getTypes();
    }

    /**
     * Represents the LIST extensions supported.
     */
    interface EList extends ISupportParameter {
        /**
         * Support for searching by channel creation time.
         */
        char CHANNEL_CREATION_TIME = 'C';
        /**
         * Support for searching by a mask.
         */
        char MASK = 'M';
        /**
         * Support for searching by not matching a mask.
         */
        char NON_MATCHING_MASK = 'N';
        /**
         * Support for searching by topic set time.
         */
        char TOPIC_SET_TIME = 'T';
        /**
         * Support for searching by user count.
         */
        char USER_COUNT = 'C';

        /**
         * Parameter name.
         */
        String NAME = "ELIST";

        /**
         * Gets the supported LIST extensions.
         *
         * @return supported extensions
         */
        @NonNull Set<Character> getExtensions();
    }

    /**
     * Represents support for ban exceptions.
     */
    interface Excepts extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "EXCEPTS";
    }

    /**
     * Represents support for extended ban masks.
     */
    interface ExtBan extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "EXTBAN";

        /**
         * Gets the prefix, if any, for extended bans.
         *
         * @return prefix, or empty if there should not be one used
         */
        @NonNull Optional<Character> getPrefix();

        /**
         * Gets the characters of types of extended bans supported.
         *
         * @return set of supported types
         */
        @NonNull Set<Character> getTypes();
    }

    /**
     * Represents the length limit of a hostname.
     */
    interface HostLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "HOSTLEN";
    }

    /**
     * Represents support for invite exemptions.
     */
    interface InvEx extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "INVEX";
    }

    /**
     * Represents limits to type A mode lists.
     */
    interface MaxTargets extends OptionalIntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "MAXTARGETS";
    }

    /**
     * Represents the length limit of a kick reason.
     */
    interface KickLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "KICKLEN";
    }

    /**
     * Represents the number of modes with parameters allowed per line.
     */
    interface Modes extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "MODES";
    }

    /**
     * Represents the network name.
     */
    interface Network extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "NETWORK";

        /**
         * Gets the network name.
         *
         * @return network name
         */
        @NonNull String getNetworkName();
    }

    /**
     * Represents the limit to nickname length.
     */
    interface NickLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "NICKLEN";
    }

    /**
     * Represents channel user modes (which define nick prefix).
     */
    interface Prefix extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "PREFIX";

        /**
         * Gets the modes granting prefixes.
         *
         * @return channel user modes
         */
        @NonNull List<ChannelUserMode> getModes();
    }

    /**
     * Represents calling LIST being safe and not disconnecting for too much info.
     */
    interface SafeList extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "SAFELIST";
    }

    /**
     * Represents support (or lack of, if no value) for maximum entries in
     * client silence lists.
     */
    interface Silence extends OptionalIntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "SILENCE";
    }

    /**
     * Lists the prefixes that can receive a status message.
     */
    interface StatusMsg extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "STATUSMSG";

        /**
         * Gets the prefixes supported.
         *
         * @return supported prefixes
         */
        Set<Character> getPrefixes();
    }

    /**
     * Represents the length limit of topics.
     */
    interface TopicLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "TOPICLEN";
    }

    /**
     * Represents the length limit of user strings.
     */
    interface UserLen extends IntegerParameter {
        /**
         * Parameter name.
         */
        String NAME = "USERLEN";
    }

    /**
     * Represents support for WHOX.
     */
    interface WhoX extends ISupportParameter {
        /**
         * Parameter name.
         */
        String NAME = "WHOX";
    }

    /**
     * Gets the name of the parameter.
     *
     * @return parameter name
     */
    @NonNull String getName();

    /**
     * Gets the unprocessed value of the parameter if provided.
     *
     * @return parameter value if set
     */
    @NonNull Optional<String> getValue();
}
